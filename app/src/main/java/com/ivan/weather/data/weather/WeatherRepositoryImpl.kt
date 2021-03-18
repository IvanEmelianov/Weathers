package com.ivan.weather.data.weather

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.ivan.weather.data.server.WeatherService
import com.ivan.weather.data.server.response.WeatherResponse
import com.ivan.weather.domain.entity.Weather
import com.ivan.weather.domain.repository.WeatherRepository
import com.ivan.weather.util.Const
import com.ivan.weather.util.Mapper
import io.reactivex.Single

class WeatherRepositoryImpl(
    private val service: WeatherService,
    private val mapper: Mapper<WeatherResponse, Weather>
): WeatherRepository {

    override fun get(lat: Double, lon: Double): Single<Weather> =
        service.getWeather(lat, lon, Const.APPID )
            .map { mapper.transform(it) }

    override fun getIcon(icon: String): Single<Bitmap> =
        service.getWeatherImg("https://openweathermap.org/img/wn/${icon}.png")
            .map { BitmapFactory.decodeStream(it.byteStream()) }
}