package com.ivan.weather.domain.repository

import android.graphics.Bitmap
import com.ivan.weather.domain.entity.Weather
import io.reactivex.Single

interface WeatherRepository {

    fun get(lat: Double, lon: Double): Single<Weather>

    fun getIcon(icon: String): Single<Bitmap>

}