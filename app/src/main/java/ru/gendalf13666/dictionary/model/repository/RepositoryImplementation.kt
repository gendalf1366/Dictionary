package ru.gendalf13666.dictionary.model.repository

import io.reactivex.Observable
import ru.gendalf13666.dictionary.model.data.DataModel
import ru.gendalf13666.dictionary.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}
