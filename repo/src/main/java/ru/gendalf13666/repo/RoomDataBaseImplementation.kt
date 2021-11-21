package ru.gendalf13666.repo

import ru.gendalf13666.repo.model.data.AppState
import ru.gendalf13666.repo.model.data.dto.SearchResultDto
import ru.gendalf13666.repo.room.HistoryDao

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> =
        mapHistoryEntityToSearchResult(historyDao.all())

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
