package com.akycfc.synechrontest.domain.usecase

import com.akycfc.synechrontest.common.Resource
import com.akycfc.synechrontest.data.model.WeatherDTO
import com.akycfc.synechrontest.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(private val weatherRepository: WeatherRepository)  {

    operator fun invoke(): Flow<Resource<WeatherDTO>> = flow{
        try{
        emit(Resource.Loading<WeatherDTO>())
        val weather = weatherRepository.getWeatherApi()
        emit(Resource.Success<WeatherDTO>(weather))
        }catch(exception : HttpException){
            emit(Resource.Error<WeatherDTO>(exception.localizedMessage ?: "Please check in"))
        }catch (exception : IOException){
            emit(Resource.Error<WeatherDTO>(exception.localizedMessage ?: "Please check in"))
        }
    }
}