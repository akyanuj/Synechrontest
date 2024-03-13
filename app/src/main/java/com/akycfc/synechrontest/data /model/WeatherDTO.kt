package com.akycfc.synechrontest.data .model

data class WeatherDTO(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Int, // 76
    val pressure: Int, // 1013
    val sea_level: Int, // 1013
    val temp: Double,
    val temp_max: Double, // 28.76
    val temp_min: Double // 28.76
)