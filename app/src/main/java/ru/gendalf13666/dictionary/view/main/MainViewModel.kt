package ru.gendalf13666.dictionary.view.main

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.gendalf13666.dictionary.model.data.AppState
import ru.gendalf13666.dictionary.utils.parseSearchResults
import ru.gendalf13666.dictionary.viewmodel.BaseViewModel

class MainViewModel(private val interactor: MainInteractor) : BaseViewModel<AppState>() {

    private val liveDataForViewToObserve: LiveData<AppState> = mutableLiveData

    fun subscribe(): LiveData<AppState> = liveDataForViewToObserve

    override fun getData(word: String, isOnline: Boolean) {
        mutableLiveData.value = AppState.Loading(null)
        cancelJob()
        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) = withContext(Dispatchers.IO) {
        mutableLiveData.postValue(parseSearchResults(interactor.getData(word, isOnline)))
    }

    override fun handleError(error: Throwable) {
        mutableLiveData.postValue(AppState.Error(error))
    }

    override fun onCleared() {
        mutableLiveData.value = AppState.Success(null)
        super.onCleared()
    }
}
