package ru.gendalf13666.history_screen

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.gendalf13666.history_screen.history.HistoryActivity
import ru.gendalf13666.history_screen.history.HistoryInteractor
import ru.gendalf13666.history_screen.history.HistoryViewModel

fun loadModules() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(listOf(historyScreen))
}

val historyScreen = module {
    scope(named<HistoryActivity>()) {
        scoped { HistoryInteractor(get(), get()) }
        viewModel { HistoryViewModel(get()) }
    }
}
