package com.example.food.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")

    object Login : Screen("login")

    object Verification : Screen("verification")

    object Registration : Screen("registration")

    object Home : Screen("home")

    object RestauranDetails : Screen("restauran")

    object FoodDetails : Screen("food")

    object ForgotPassword : Screen("forgot")
}