package com.akycfc.synechrontest.domain.repository

import com.akycfc.synechrontest.data.model.WeatherDTO

interface WeatherRepository {

    suspend fun getWeatherApi()  : WeatherDTO
}