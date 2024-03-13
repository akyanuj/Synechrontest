package com.akycfc.synechrontest.data.Repository

import com.akycfc.synechrontest.data.model.WeatherDTO
import com.akycfc.synechrontest.data.remote.WeatherApi
import com.akycfc.synechrontest.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository   {
    override suspend fun getWeatherApi() : WeatherDTO {
        return api.getWeatherDetails()
    }
}