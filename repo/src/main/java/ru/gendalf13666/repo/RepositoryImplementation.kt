package ru.gendalf13666.repo

import ru.gendalf13666.repo.model.data.DataModel

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> = dataSource.getData(word)
}
