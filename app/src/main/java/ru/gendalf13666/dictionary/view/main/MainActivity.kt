package ru.gendalf13666.dictionary.view.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.AppUpdateType.IMMEDIATE
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.scope.currentScope
import ru.gendalf13666.dictionary.R
import ru.gendalf13666.dictionary.di.loadModules
import ru.gendalf13666.dictionary.utils.convertMeaningsToString
import ru.gendalf13666.dictionary.utils.network.isOnline
import ru.gendalf13666.dictionary.view.base.BaseActivity
import ru.gendalf13666.dictionary.view.description.DescriptionActivity
import ru.gendalf13666.dictionary.view.main.adapter.MainAdapter
import ru.gendalf13666.repo.model.data.AppState
import ru.gendalf13666.repo.model.data.userdata.DataModel

private const val BOTTOM_SHEET_FRAGMENT_DIALOG_TAG = "74m54328"
private const val HISTORY_ACTIVITY_PATH = "ru.gendalf13666.history_screen.history.HistoryActivity"
private const val HISTORY_ACTIVITY_FEATURE_NAME = "historyScreen"
private const val REQUEST_CODE = 34

class MainActivity : BaseActivity<AppState, MainInteractor>() {

    override val layoutRes = R.layout.activity_main
    override lateinit var model: MainViewModel
    private lateinit var splitInstallManager: SplitInstallManager
    private lateinit var appUpdateManager: AppUpdateManager
    private val adapter: MainAdapter by lazy { MainAdapter(onListItemClickListener) }
    private val fabClickListener = View.OnClickListener {
        SearchDialogFragment.newInstance().apply {
            setOnSearchClickListener(onSearchClickListener)
            show(supportFragmentManager, BOTTOM_SHEET_FRAGMENT_DIALOG_TAG)
        }
    }
    private val onListItemClickListener = object : MainAdapter.OnListItemClickListener {
        override fun onItemClick(data: DataModel) {
            startActivity(
                DescriptionActivity.getIntent(
                    this@MainActivity, data.text,
                    convertMeaningsToString(data.meanings),
                    data.meanings[0].imageUrl
                )
            )
        }
    }
    private val onSearchClickListener = object : SearchDialogFragment.OnSearchClickListener {
        override fun onClick(searchWord: String) {
            isNetworkAvailable = isOnline(applicationContext)
            if (isNetworkAvailable) model.getData(searchWord, isNetworkAvailable)
            else showNoInternetConnectionDialog()
        }
    }
    private val stateUpdatedListener: InstallStateUpdatedListener = InstallStateUpdatedListener {
        it?.let {
            if (it.installStatus() == InstallStatus.DOWNLOADED) popupSnackBarForCompleteUpdate()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        initViews()
        checkForUpdates()
    }

    override fun onResume() {
        super.onResume()
        appUpdateManager
            .appUpdateInfo
            .addOnSuccessListener {
                if (it.installStatus() == InstallStatus.DOWNLOADED) {
                    popupSnackBarForCompleteUpdate()
                }
                if (it.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS) {
                    appUpdateManager.startUpdateFlowForResult(it, IMMEDIATE, this, REQUEST_CODE)
                }
            }
    }

    private fun initViewModel() {
        check(main_activity_recyclerview.adapter == null) { "The ViewModel should be initialized first." }
        loadModules()
        val viewModel: MainViewModel by currentScope.inject()
        model = viewModel
        model.subscribe().observe(this@MainActivity, Observer<AppState> { renderData(it) })
    }

    private fun initViews() {
        search_fab.setOnClickListener(fabClickListener)
        main_activity_recyclerview.adapter = adapter
    }

    override fun setDataToAdapter(data: List<DataModel>) {
        adapter.setData(data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_screen_menu, menu)
        menu?.findItem(R.id.menu_settings)?.isVisible = Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("InlinedApi")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_history -> {
                splitInstallManager = SplitInstallManagerFactory.create(applicationContext)
                val request =
                    SplitInstallRequest
                        .newBuilder()
                        .addModule(HISTORY_ACTIVITY_FEATURE_NAME)
                        .build()

                splitInstallManager
                    .startInstall(request)
                    .addOnSuccessListener {
                        val intent = Intent().setClassName(packageName, HISTORY_ACTIVITY_PATH)
                        startActivity(intent)
                    }
                    .addOnFailureListener {
                        Toast.makeText(
                            applicationContext,
                            "Couldn't download feature: " + it.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                true
            }
            R.id.menu_settings -> {
                startActivityForResult(Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY), 42)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun checkForUpdates() {
        appUpdateManager = AppUpdateManagerFactory.create(applicationContext)
        appUpdateManager.appUpdateInfo.addOnSuccessListener { appUpdateIntent ->
            if (appUpdateIntent.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE &&
                appUpdateIntent.isUpdateTypeAllowed(IMMEDIATE)
            ) {
                appUpdateManager.registerListener(stateUpdatedListener)
                appUpdateManager.startUpdateFlowForResult(
                    appUpdateIntent,
                    IMMEDIATE,
                    this,
                    REQUEST_CODE
                )
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            when (resultCode) {
                RESULT_OK -> { appUpdateManager.unregisterListener(stateUpdatedListener) }
                RESULT_CANCELED -> { Toast.makeText(applicationContext, "Action canceled", Toast.LENGTH_LONG).show() }
                else -> { Toast.makeText(applicationContext, "Error: result code $resultCode", Toast.LENGTH_LONG).show() }
            }
        }
    }

    private fun popupSnackBarForCompleteUpdate() {
        Snackbar.make(
            findViewById(R.id.activity_main_layout),
            "An update has just been downloaded.",
            Snackbar.LENGTH_INDEFINITE
        ).apply {
            setAction("INSTALL") { appUpdateManager.completeUpdate() }
            show()
        }
    }
}
