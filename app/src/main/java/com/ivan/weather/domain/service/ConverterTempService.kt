package com.ivan.weather.domain.service

interface ConverterTempService {

    fun convertInCelsius(temperature: Double): Double

    fun convertInFahrenheit(temperature: Double): Double

}