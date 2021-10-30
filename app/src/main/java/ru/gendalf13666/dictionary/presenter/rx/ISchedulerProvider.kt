package ru.gendalf13666.dictionary.presenter.rx

import io.reactivex.Scheduler

interface ISchedulerProvider {

    fun ui(): Scheduler

    fun io(): Scheduler
}
