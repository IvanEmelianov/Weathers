package com.ivan.weather.domain.entity

data class City(
    val lat: Double,
    val lon: Double,
    val name: String = ""
)