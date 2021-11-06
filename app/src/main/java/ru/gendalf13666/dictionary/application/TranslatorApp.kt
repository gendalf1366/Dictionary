package ru.gendalf13666.dictionary.application

import android.app.Application
import org.koin.core.context.startKoin
import ru.gendalf13666.dictionary.di.application
import ru.gendalf13666.dictionary.di.mainScreen

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}
