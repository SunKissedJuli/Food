package com.example.food.Screen.RestaurantDetails

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RestaurantDetailsViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(RestaurantDetailsUiState())
    val uiState : StateFlow<RestaurantDetailsUiState> = _uiState
}