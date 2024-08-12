package com.example.food.Screen.Home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState:StateFlow<HomeUiState> = _uiState

    fun updateSearchString(searchText: String){
        _uiState.update { it.copy(searchText = searchText) }
    }

    fun updateSearchContainer(){
        _uiState.update { it.copy(searchContainer = !uiState.value.searchContainer) }
    }
}