package ru.gendalf13666.dictionary.view.main

import ru.gendalf13666.dictionary.utils.mapSearchResultToResult
import ru.gendalf13666.dictionary.viewmodel.Interactor
import ru.gendalf13666.repo.Repository
import ru.gendalf13666.repo.RepositoryLocal
import ru.gendalf13666.repo.model.data.AppState
import ru.gendalf13666.repo.model.data.dto.SearchResultDto

class MainInteractor (
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(mapSearchResultToResult(repositoryLocal.getData(word)))
        }
        return appState
    }
}
