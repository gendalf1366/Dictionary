package ru.gendalf13666.dictionary.view.history

import ru.gendalf13666.dictionary.viewmodel.Interactor
import ru.gendalf13666.repo.Repository
import ru.gendalf13666.repo.RepositoryLocal
import ru.gendalf13666.repo.model.data.AppState
import ru.gendalf13666.repo.model.data.DataModel

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
