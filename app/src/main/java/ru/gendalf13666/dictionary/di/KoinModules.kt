package ru.gendalf13666.dictionary.di

import androidx.room.Room
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.gendalf13666.dictionary.view.main.MainActivity
import ru.gendalf13666.dictionary.view.main.MainInteractor
import ru.gendalf13666.dictionary.view.main.MainViewModel
import ru.gendalf13666.repo.*
import ru.gendalf13666.repo.model.data.dto.SearchResultDto
import ru.gendalf13666.repo.room.HistoryDataBase

fun loadModules() = loadModules

private val loadModules by lazy { loadKoinModules(listOf(application, mainScreen)) }

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDBase").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<SearchResultDto>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<SearchResultDto>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get())) }
}

val mainScreen = module {
    scope(named<MainActivity>()) {
        viewModel { MainViewModel(get()) }
        scoped { MainInteractor(get(), get()) }
    }

}
