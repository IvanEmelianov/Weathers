package com.ivan.weather.domain.service

import com.ivan.weather.domain.entity.City
import io.reactivex.Single

interface LocationService {

    fun get(): Single<City>

}