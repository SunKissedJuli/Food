package com.example.food.Screen.FoodDetails

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class FoodDetailsViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(FoodDetailsUiState())
    val uiState: StateFlow<FoodDetailsUiState> = _uiState

    fun updateCounterPlus(){
        _uiState.update { it.copy(count = uiState.value.count+1, cost = ((uiState.value.firstCost*(uiState.value.count+1)).toString())) }
    }

    fun updateCounterMinus(){
        if(uiState.value.count>1){
            _uiState.update { it.copy(count = uiState.value.count-1, cost = ((uiState.value.firstCost*(uiState.value.count-1)).toString())) }
        }else if(uiState.value.count==1){
            _uiState.update { it.copy(count = uiState.value.count-1) }
        }
    }
}