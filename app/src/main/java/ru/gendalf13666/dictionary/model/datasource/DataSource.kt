package ru.gendalf13666.dictionary.model.datasource

interface DataSource<T> {
    suspend fun getData(word: String): T
}
