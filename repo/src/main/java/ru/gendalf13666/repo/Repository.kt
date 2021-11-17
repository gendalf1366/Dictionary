package ru.gendalf13666.repo

interface Repository<T> {
    suspend fun getData(word: String): T
}
