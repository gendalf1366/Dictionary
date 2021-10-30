package ru.gendalf13666.dictionary.model.datasource

import io.reactivex.Observable
import ru.gendalf13666.dictionary.model.data.DataModel

class DataSourceLocal(private val remoteProvider: RoomDataBaseImplementation = RoomDataBaseImplementation()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}
