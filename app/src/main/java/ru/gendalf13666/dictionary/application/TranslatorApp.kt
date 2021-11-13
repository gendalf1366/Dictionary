package ru.gendalf13666.dictionary.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.gendalf13666.dictionary.di.application
import ru.gendalf13666.dictionary.di.historyScreen
import ru.gendalf13666.dictionary.di.mainScreen

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}
