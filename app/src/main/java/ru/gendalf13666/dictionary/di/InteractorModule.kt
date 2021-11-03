package ru.gendalf13666.dictionary.di

import dagger.Module
import dagger.Provides
import ru.gendalf13666.dictionary.model.data.DataModel
import ru.gendalf13666.dictionary.model.repository.Repository
import ru.gendalf13666.dictionary.view.main.MainInteractor
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}
