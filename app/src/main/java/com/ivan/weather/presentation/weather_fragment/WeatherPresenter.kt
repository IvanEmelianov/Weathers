package com.ivan.weather.presentation.weather_fragment

import android.graphics.Bitmap
import android.location.LocationManager
import com.arellomobile.mvp.InjectViewState
import com.ivan.weather.domain.entity.Weather
import com.ivan.weather.domain.interactor.WeatherInteractor
import com.ivan.weather.domain.service.ConverterTempService
import com.ivan.weather.domain.service.LocationService
import com.ivan.weather.presentation.base.mvp.BasePresenter
import io.reactivex.rxkotlin.Singles

@InjectViewState
class WeatherPresenter(
    private val locationService: LocationService,
    private val interactor: WeatherInteractor,
    private val converterTempService: ConverterTempService
) : BasePresenter<WeatherView>(){

    private var temperature: Double = 0.0

    fun getWeather(){
        Singles.zip(interactor.getWeatherMyCity(), interactor.getIconWeatherMyCity())
            .doOnSubscribe { viewState.showLoading() }
            .doFinally { viewState.hideLoading() }
            .doOnSuccess { updateWeather(it.first, it.second) }
            .subscribe()
            .autoDisposeOnDestroy()
    }

    fun getWeatherChoseCity(lat: Double, lon: Double){
        Singles.zip(interactor.getWeatherAnotherCity(lat, lon), interactor.getIconWeatherAnotherCity(lat, lon))
            .doOnSubscribe { viewState.showLoading() }
            .doFinally { viewState.hideLoading() }
            .doOnSuccess { updateWeather(it.first, it.second) }
            .subscribe()
            .autoDisposeOnDestroy()
    }


    private fun updateWeather(weather: Weather, bitmap: Bitmap){
        // Since the temperature in Celsius comes,
        // you need to set the state of the radio button in Celsius
        viewState.defaultStateRadioButton()
        viewState.setWeather(weather)

        temperature = weather.temp
        viewState.setIcon(bitmap)
    }

    fun transferTempToCelsius(){
        temperature = converterTempService.convertInCelsius(temperature)
        viewState.updateTemperature(temperature, "º")
    }

    fun transferTempToFahrenheit(){
        temperature = converterTempService.convertInFahrenheit(temperature)
        viewState.updateTemperature(temperature, "F")
    }

    fun getMyLocation() = locationService.get()

    fun checkGPS(manager: LocationManager){
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER))
            viewState.enabledGPS()
        else
            viewState.requestPermissionsGetLocation()
    }

}