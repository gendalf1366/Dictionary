package ru.gendalf13666.dictionary.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.gendalf13666.dictionary.view.main.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
