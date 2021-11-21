package ru.gendalf13666.history_screen.history

import ru.gendalf13666.dictionary.utils.mapSearchResultToResult
import ru.gendalf13666.dictionary.viewmodel.Interactor
import ru.gendalf13666.repo.Repository
import ru.gendalf13666.repo.RepositoryLocal
import ru.gendalf13666.repo.model.data.AppState
import ru.gendalf13666.repo.model.data.dto.SearchResultDto

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}
