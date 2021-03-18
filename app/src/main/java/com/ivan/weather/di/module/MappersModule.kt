package com.ivan.weather.di.module

import com.ivan.weather.data.server.response.WeatherResponse
import com.ivan.weather.data.weather.WeatherMapper
import com.ivan.weather.domain.entity.Weather
import com.ivan.weather.util.Mapper
import dagger.Module
import dagger.Provides

@Module
class MappersModule {

    @Provides
    fun provideFaqMapper(): Mapper<WeatherResponse, Weather> =
        WeatherMapper()

}