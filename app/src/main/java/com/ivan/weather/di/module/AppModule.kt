package com.ivan.weather.di.module

import com.ivan.weather.di.WeatherApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: WeatherApplication)
            = application.applicationContext!!

}