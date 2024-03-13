package com.akycfc.synechrontest.data.remote

import com.akycfc.synechrontest.data.model.WeatherDTO
import retrofit2.http.GET

interface WeatherApi {

    @GET("weather?lat=0&lon=0&appid=c6e381d8c7ff98f0fee43775817cf6ad&units=metric")
    suspend fun getWeatherDetails(): WeatherDTO

}