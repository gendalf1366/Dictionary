package ru.gendalf13666.dictionary.model.repository

interface Repository<T> {
    suspend fun getData(word: String): T
}
