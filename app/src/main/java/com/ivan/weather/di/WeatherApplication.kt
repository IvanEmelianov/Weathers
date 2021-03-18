package com.ivan.weather.di

import android.annotation.SuppressLint
import com.ivan.weather.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

@SuppressLint("Registered")
class WeatherApplication : DaggerApplication() {

    override fun onCreate()  = super.onCreate()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().application(this).build()
}