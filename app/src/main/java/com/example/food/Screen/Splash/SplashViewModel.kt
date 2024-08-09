package com.example.food.Screen.Splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.food.navigation.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel() : ViewModel() {

    fun IsAutorizeSimulate(navController: NavHostController){
        viewModelScope.launch {
            delay(2000)
            navController.navigate(Screen.Login.route)
        }

    }
}