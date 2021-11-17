package ru.gendalf13666.repo

interface DataSource<T> {
    suspend fun getData(word: String): T
}
