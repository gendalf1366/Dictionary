package ru.gendalf13666.repo

import ru.gendalf13666.repo.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {
    suspend fun saveToDB(appState: AppState)
}
