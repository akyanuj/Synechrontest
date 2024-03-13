package com.akycfc.synechrontest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.akycfc.synechrontest.presentation.theme.SynechronTestTheme
import com.akycfc.synechrontest.presentation.viewmodel.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SynechronTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val vm: WeatherViewModel = hiltViewModel()
                    Greeting(vm)
                }
            }
        }
    }
}

@Composable
fun Greeting(vm: WeatherViewModel) {
    val value = vm.state.value
    Box(modifier = Modifier.fillMaxSize()){
        value.weather?.let {
            Text(
                text = "Hello ${it.temp}!",
                modifier = Modifier.fillMaxWidth()
            )
        }
        value.error?.let{
            ErrorScreen(error = it)
        }
        if (value.loading) LoadingScreen()
    }

}

@Composable
fun ErrorScreen(error: String, modifier: Modifier = Modifier) {
    Text(
        text = "$error",
        modifier = modifier
    )
}
@Composable
fun LoadingScreen() {
   CircularProgressIndicator()
}

