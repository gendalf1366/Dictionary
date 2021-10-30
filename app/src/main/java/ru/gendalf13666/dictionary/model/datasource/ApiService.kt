package ru.gendalf13666.dictionary.model.datasource

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import ru.gendalf13666.dictionary.model.data.DataModel

interface ApiService {

    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Observable<List<DataModel>>
}
