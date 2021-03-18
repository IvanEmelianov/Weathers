package com.ivan.weather.di.module

import com.ivan.weather.presentation.chose_city_dialog.ChoseCityDialog
import com.ivan.weather.presentation.chose_city_dialog.ChoseCityModule
import com.ivan.weather.presentation.weather_fragment.WeatherFragment
import com.ivan.weather.presentation.weather_fragment.WeatherModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector(modules = [WeatherModule::class])
    abstract fun bindWeatherFragment(): WeatherFragment

    @ContributesAndroidInjector(modules = [ChoseCityModule::class])
    abstract fun bindChoseCityDialog(): ChoseCityDialog

}