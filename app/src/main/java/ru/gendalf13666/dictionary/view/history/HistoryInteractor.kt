package ru.gendalf13666.dictionary.view.history

import ru.gendalf13666.dictionary.model.data.AppState
import ru.gendalf13666.dictionary.model.data.DataModel
import ru.gendalf13666.dictionary.model.repository.Repository
import ru.gendalf13666.dictionary.model.repository.RepositoryLocal
import ru.gendalf13666.dictionary.viewmodel.Interactor

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
