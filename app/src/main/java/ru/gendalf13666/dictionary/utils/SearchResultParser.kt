package ru.gendalf13666.dictionary.utils

import ru.gendalf13666.dictionary.model.data.AppState
import ru.gendalf13666.dictionary.model.data.DataModel
import ru.gendalf13666.dictionary.model.data.Meanings

fun parseSearchResults(state: AppState): AppState {
    val newSearchResults = arrayListOf<DataModel>()
    when (state) {
        is AppState.Success -> {
            val searchResults = state.data
            if (!searchResults.isNullOrEmpty()) {
                for (searchResult in searchResults) {
                    parseResult(searchResult, newSearchResults)
                }
            }
        }
    }

    return AppState.Success(newSearchResults)
}

private fun parseResult(dataModel: DataModel, newDataModels: ArrayList<DataModel>) {
    if (!dataModel.text.isNullOrBlank() && !dataModel.meanings.isNullOrEmpty()) {
        val newMeanings = arrayListOf<Meanings>()
        for (meaning in dataModel.meanings) {
            if (meaning.translation != null && !meaning.translation.text.isNullOrBlank()) {
                newMeanings.add(Meanings(meaning.translation, meaning.imageUrl))
            }
        }
        if (newMeanings.isNotEmpty()) {
            newDataModels.add(DataModel(dataModel.text, newMeanings))
        }
    }
}

fun convertMeaningsToString(meanings: List<Meanings>): String {
    var meaningsSeparatedByComma = String()
    for ((index, meaning) in meanings.withIndex()) {
        meaningsSeparatedByComma += if (index + 1 != meanings.size) {
            String.format("%s%s", meaning.translation?.text, ", ")
        } else {
            meaning.translation?.text
        }
    }
    return meaningsSeparatedByComma
}
