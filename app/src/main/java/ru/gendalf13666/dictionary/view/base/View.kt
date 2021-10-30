package ru.gendalf13666.dictionary.view.base

import ru.gendalf13666.dictionary.model.data.AppState

interface View {

    fun renderData(appState: AppState)
}
