package ru.gendalf13666.dictionary.view.main

import ru.gendalf13666.dictionary.viewmodel.Interactor
import ru.gendalf13666.dictionary.model.data.AppState
import ru.gendalf13666.dictionary.model.data.DataModel
import ru.gendalf13666.dictionary.model.repository.Repository

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean) =
        AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
}
