package ru.gendalf13666.dictionary.view.main

import io.reactivex.Observable
import ru.gendalf13666.dictionary.model.data.AppState
import ru.gendalf13666.dictionary.model.data.DataModel
import ru.gendalf13666.dictionary.model.repository.Repository
import ru.gendalf13666.dictionary.presenter.Interactor

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}
