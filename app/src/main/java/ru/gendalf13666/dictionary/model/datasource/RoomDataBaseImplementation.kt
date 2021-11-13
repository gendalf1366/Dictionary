package ru.gendalf13666.dictionary.model.datasource

import ru.gendalf13666.dictionary.room.HistoryDao
import ru.gendalf13666.dictionary.utils.convertDataModelSuccessToEntity
import ru.gendalf13666.dictionary.utils.mapHistoryEntityToSearchResult
import ru.gendalf13666.dictionary.model.data.AppState
import ru.gendalf13666.dictionary.model.data.DataModel

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> =
        mapHistoryEntityToSearchResult(historyDao.all())

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
