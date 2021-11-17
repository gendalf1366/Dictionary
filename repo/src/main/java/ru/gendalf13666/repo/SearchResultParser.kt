package ru.gendalf13666.repo

import ru.gendalf13666.repo.model.data.AppState
import ru.gendalf13666.repo.model.data.DataModel
import ru.gendalf13666.repo.room.HistoryEntity

fun mapHistoryEntityToSearchResult(list: List<HistoryEntity>): List<DataModel> {
    val searchResult = ArrayList<DataModel>()
    if (!list.isNullOrEmpty()) {
        for (entity in list) {
            searchResult.add(DataModel(entity.word, null))
        }
    }
    return searchResult
}

fun convertDataModelSuccessToEntity(appState: AppState): HistoryEntity? {
    return when (appState) {
        is AppState.Success -> {
            val searchResult = appState.data
            if (searchResult.isNullOrEmpty() || searchResult[0].text.isNullOrEmpty()) {
                null
            } else {
                HistoryEntity(
                    searchResult[0].text!!,
                    null
                )
            }
        }
        else -> null
    }
}
