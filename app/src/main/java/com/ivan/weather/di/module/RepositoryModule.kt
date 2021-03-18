package com.ivan.weather.di.module

import android.content.Context
import com.google.android.gms.location.LocationServices
import com.ivan.weather.data.city.CityRepositoryImpl
import com.ivan.weather.data.location.LocationServiceImpl
import com.ivan.weather.data.server.WeatherService
import com.ivan.weather.data.server.response.WeatherResponse
import com.ivan.weather.data.weather.ConverterTempServiceImpl
import com.ivan.weather.data.weather.WeatherRepositoryImpl
import com.ivan.weather.domain.entity.Weather
import com.ivan.weather.domain.repository.CityRepository
import com.ivan.weather.domain.repository.WeatherRepository
import com.ivan.weather.domain.service.ConverterTempService
import com.ivan.weather.domain.service.LocationService
import com.ivan.weather.util.Mapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideLocationServiceImpl(
        context: Context
    ): LocationService =
        LocationServiceImpl(
            context,
            LocationServices.getFusedLocationProviderClient(context)
        )

    @Provides
    @Singleton
    fun provideConverterTempServiceImpl(): ConverterTempService =
        ConverterTempServiceImpl()

    @Provides
    @Singleton
    fun provideCityRepositoryImpl(): CityRepository =
        CityRepositoryImpl()

    @Provides
    @Singleton
    fun provideWeatherRepository(
         service: WeatherService,
         mapper: Mapper<WeatherResponse, Weather>
    ): WeatherRepository =
        WeatherRepositoryImpl(
            service, mapper
        )

}