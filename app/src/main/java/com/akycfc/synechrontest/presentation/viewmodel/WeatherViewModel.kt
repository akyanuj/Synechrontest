package com.akycfc.synechrontest.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akycfc.synechrontest.common.Resource
import com.akycfc.synechrontest.data.model.WeatherDTO
import com.akycfc.synechrontest.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(val useCase: GetWeatherUseCase) : ViewModel() {
    private val _weatherState = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _weatherState
    init {
        getWeather()
    }

   private fun  getWeather(){

        useCase().onEach { result ->
            when(result){
                is Resource.Loading -> { WeatherState(loading = true)}
                is Resource.Error ->{ WeatherState(weather = result.data)}
                is Resource.Success ->{ WeatherState(error = result.message ?: "Something went wrong")}
            }
        }.launchIn(viewModelScope)
    }
}

data class WeatherState(
    val weather: WeatherDTO? = null  , //
    val error: String = "",//
    val loading: Boolean = false
)