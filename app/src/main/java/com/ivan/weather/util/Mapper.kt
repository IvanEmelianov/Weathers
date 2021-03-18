package com.ivan.weather.util

interface Mapper<FROM, TO> {
    fun transform(value: FROM): TO
}
