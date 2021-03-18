package com.ivan.weather.domain.repository

import com.ivan.weather.domain.entity.City
import io.reactivex.Single

interface CityRepository {

    fun getCity(): Single<List<City>>

}