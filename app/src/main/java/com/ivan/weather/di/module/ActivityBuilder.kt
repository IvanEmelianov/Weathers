package com.ivan.weather.di.module

import com.ivan.weather.presentation.app.AppActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun bindAppActivity(): AppActivity

}
