package com.ivan.weather.data.weather

import com.ivan.weather.domain.service.ConverterTempService

class ConverterTempServiceImpl(): ConverterTempService {

    override fun convertInCelsius(temperature: Double): Double =
        (temperature - 32) * 5/9


    override fun convertInFahrenheit(temperature: Double): Double =
        temperature * 9/5 + 32

}