package com.example.food.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.food.Screen.Home.HomeScreen
import com.example.food.Screen.Login.LoginScreen
import com.example.food.Screen.Registration.RegistrationScreen
import com.example.food.Screen.Splash.SplashScreen
import com.example.food.Screen.Verification.VerificationScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = Screen.Splash.route,
    enterTransition: EnterTransition = EnterTransition.None,
    exitTransition: ExitTransition = ExitTransition.None
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }

        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(Screen.Registration.route) {
            RegistrationScreen(navController)
        }

        composable(Screen.Verification.route) {
            VerificationScreen(navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
    }
}