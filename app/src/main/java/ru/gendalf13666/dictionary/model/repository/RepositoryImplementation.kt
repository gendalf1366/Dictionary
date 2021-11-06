package ru.gendalf13666.dictionary.model.repository

import ru.gendalf13666.dictionary.model.data.DataModel
import ru.gendalf13666.dictionary.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> = dataSource.getData(word)
}
