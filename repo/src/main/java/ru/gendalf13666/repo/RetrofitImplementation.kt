package ru.gendalf13666.repo

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.gendalf13666.repo.api.ApiService
import ru.gendalf13666.repo.api.BaseInterceptor
import ru.gendalf13666.repo.model.data.dto.SearchResultDto

class RetrofitImplementation : DataSource<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> =
        getService(BaseInterceptor.interceptor).searchAsync(word).await()

    private fun getService(interceptor: Interceptor): ApiService =
        createRetrofit(interceptor).create(ApiService::class.java)

    private fun createRetrofit(interceptor: Interceptor) = Retrofit.Builder()
        .baseUrl(BASE_URL_LOCATIONS)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(createOkHttpClient(interceptor))
        .build()

    private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return httpClient.build()
    }

    companion object {
        private const val BASE_URL_LOCATIONS = "https://dictionary.skyeng.ru/api/public/v1/"
    }
}
