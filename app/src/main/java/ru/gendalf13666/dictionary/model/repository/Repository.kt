package ru.gendalf13666.dictionary.model.repository

import io.reactivex.Observable

interface Repository<T> {

    fun getData(word: String): Observable<T>
}
