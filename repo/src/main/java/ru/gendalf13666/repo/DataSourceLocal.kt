package ru.gendalf13666.repo

import ru.gendalf13666.repo.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {
    suspend fun saveToDB(appState: AppState)
}
