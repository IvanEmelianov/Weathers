package com.ivan.weather.data.weather

import com.ivan.weather.data.server.response.WeatherResponse
import com.ivan.weather.domain.entity.Weather
import com.ivan.weather.util.Const
import com.ivan.weather.util.Mapper

class WeatherMapper : Mapper<WeatherResponse, Weather>{
    override fun transform(value: WeatherResponse): Weather =
        Weather(
            city = value.name,
            temp = value.main.temp - Const.KELVIN,
            description = value.weather.first().description,
            wind = value.wind.speed,
            pressure = value.main.pressure,
            humidity = value.main.humidity,
            icon = value.weather.first().icon
        )


}
