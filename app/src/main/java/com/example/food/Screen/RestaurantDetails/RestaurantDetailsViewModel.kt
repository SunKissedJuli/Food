package com.example.food.Screen.RestaurantDetails

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RestaurantDetailsViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(RestaurantDetailsUiState())
    val uiState : StateFlow<RestaurantDetailsUiState> = _uiState

    fun showFilterDialog(){
        _uiState.update { it.copy(isFilterDialog = !uiState.value.isFilterDialog) }
    }
}