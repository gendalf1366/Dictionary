package ru.gendalf13666.dictionary.model.datasource

import ru.gendalf13666.dictionary.model.data.DataModel

class RoomDataBaseImplementation : DataSource<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> { TODO("not implemented") }
}
