package ru.gendalf13666.dictionary.model.datasource

import ru.gendalf13666.dictionary.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {
    suspend fun saveToDB(appState: AppState)
}
