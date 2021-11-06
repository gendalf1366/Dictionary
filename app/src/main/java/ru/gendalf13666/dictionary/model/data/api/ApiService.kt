package ru.gendalf13666.dictionary.model.data.api

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import ru.gendalf13666.dictionary.model.data.DataModel

interface ApiService {
    @GET("words/search")
    fun searchAsync(@Query("search") wordToSearch: String): Deferred<List<DataModel>>
}
