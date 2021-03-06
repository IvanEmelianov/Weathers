package com.ivan.weather.presentation.weather_fragment

import android.graphics.Bitmap
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.ivan.weather.domain.entity.Weather
import com.ivan.weather.presentation.base.mvp.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface WeatherView: BaseView {

    fun setWeather(weather: Weather)

    fun setIcon(icon: Bitmap)

    fun updateTemperature(temp: Double, value: String)

    fun showLoading()

    fun hideLoading()

    fun defaultStateRadioButton()

    fun enabledGPS()

    fun requestPermissionsGetLocation()

}