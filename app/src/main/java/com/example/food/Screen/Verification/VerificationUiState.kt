package com.example.food.Screen.Verification

data class VerificationUiState(
    var code: List<String> = listOf("","","",""),
    var email: String = "example@gmail.com",
)
