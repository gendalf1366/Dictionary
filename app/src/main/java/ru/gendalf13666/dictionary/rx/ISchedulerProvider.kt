package ru.gendalf13666.dictionary.rx

import io.reactivex.Scheduler

interface ISchedulerProvider {
    fun ui(): Scheduler
    fun io(): Scheduler
}
