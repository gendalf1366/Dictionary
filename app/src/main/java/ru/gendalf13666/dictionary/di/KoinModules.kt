package ru.gendalf13666.dictionary.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.gendalf13666.dictionary.model.data.DataModel
import ru.gendalf13666.dictionary.model.datasource.RetrofitImplementation
import ru.gendalf13666.dictionary.model.datasource.RoomDataBaseImplementation
import ru.gendalf13666.dictionary.model.repository.Repository
import ru.gendalf13666.dictionary.model.repository.RepositoryImplementation
import ru.gendalf13666.dictionary.view.main.MainInteractor
import ru.gendalf13666.dictionary.view.main.MainViewModel

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImplementation(RetrofitImplementation())
    }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImplementation(RoomDataBaseImplementation())
    }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
