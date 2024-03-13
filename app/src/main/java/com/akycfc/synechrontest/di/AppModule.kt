package com.akycfc.synechrontest.di

import com.akycfc.synechrontest.common.Constants
import com.akycfc.synechrontest.data.Repository.WeatherRepositoryImpl
import com.akycfc.synechrontest.data.remote.WeatherApi
import com.akycfc.synechrontest.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // retrofit
    // getWeatherImpl
    //wethaer api

    @Provides
    @Singleton
    fun provideOkHTtpCleint(): OkHttpClient {
        return OkHttpClient.Builder().build()

    }

    @Provides
    @Singleton
    fun provideWeatherApi(okHttpClient: OkHttpClient): WeatherApi {
        return Retrofit.Builder().client(okHttpClient)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherApi: WeatherApi): WeatherRepository{
        return WeatherRepositoryImpl(weatherApi)
    }


}