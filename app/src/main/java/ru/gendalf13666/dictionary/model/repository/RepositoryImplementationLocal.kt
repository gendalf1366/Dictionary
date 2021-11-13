package ru.gendalf13666.dictionary.model.repository

import ru.gendalf13666.dictionary.model.data.AppState
import ru.gendalf13666.dictionary.model.data.DataModel
import ru.gendalf13666.dictionary.model.datasource.DataSourceLocal

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<DataModel>>) :
    RepositoryLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}
