package ru.gendalf13666.dictionary.model.datasource

import io.reactivex.Observable
import ru.gendalf13666.dictionary.model.data.DataModel

class RoomDataBaseImplementation : DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> { TODO("not implemented") }
}
