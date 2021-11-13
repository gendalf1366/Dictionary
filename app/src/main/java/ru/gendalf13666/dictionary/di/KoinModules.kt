package ru.gendalf13666.dictionary.di

import androidx.room.Room
import org.koin.dsl.module
import ru.gendalf13666.dictionary.model.data.DataModel
import ru.gendalf13666.dictionary.model.datasource.RetrofitImplementation
import ru.gendalf13666.dictionary.model.datasource.RoomDataBaseImplementation
import ru.gendalf13666.dictionary.model.repository.Repository
import ru.gendalf13666.dictionary.model.repository.RepositoryImplementation
import ru.gendalf13666.dictionary.model.repository.RepositoryImplementationLocal
import ru.gendalf13666.dictionary.model.repository.RepositoryLocal
import ru.gendalf13666.dictionary.room.HistoryDataBase
import ru.gendalf13666.dictionary.view.history.HistoryInteractor
import ru.gendalf13666.dictionary.view.history.HistoryViewModel
import ru.gendalf13666.dictionary.view.main.MainInteractor
import ru.gendalf13666.dictionary.view.main.MainViewModel

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDBase").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(
        RoomDataBaseImplementation(get())
    )
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
