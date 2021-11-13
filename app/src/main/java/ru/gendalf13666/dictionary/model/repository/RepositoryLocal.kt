package ru.gendalf13666.dictionary.model.repository

import ru.gendalf13666.dictionary.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {
    suspend fun saveToDB(appState: AppState)
}
