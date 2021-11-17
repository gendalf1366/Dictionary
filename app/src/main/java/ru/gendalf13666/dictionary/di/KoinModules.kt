package ru.gendalf13666.dictionary.di

import androidx.room.Room
import org.koin.dsl.module
import ru.gendalf13666.dictionary.view.history.HistoryInteractor
import ru.gendalf13666.dictionary.view.history.HistoryViewModel
import ru.gendalf13666.dictionary.view.main.MainInteractor
import ru.gendalf13666.dictionary.view.main.MainViewModel
import ru.gendalf13666.repo.*
import ru.gendalf13666.repo.model.data.DataModel
import ru.gendalf13666.repo.room.HistoryDataBase

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDBase").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> {
        RepositoryImplementation(
            RetrofitImplementation()
        )
    }
    single<RepositoryLocal<List<DataModel>>> {
        RepositoryImplementationLocal(
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
