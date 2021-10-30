package ru.gendalf13666.dictionary.presenter

import ru.gendalf13666.dictionary.view.base.View
import ru.gendalf13666.dictionary.model.data.AppState

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
