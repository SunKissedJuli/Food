package com.example.food.Screen.Registration

import androidx.lifecycle.ViewModel
import com.example.food.Screen.Login.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegistrationViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(RegistrationUiState())
    val uiState: StateFlow<RegistrationUiState> = _uiState.asStateFlow()

    fun updateEmail(email: String){
        _uiState.update { it.copy(email = email) }
    }

    fun updatePassword(password: String){
        _uiState.update { it.copy(password = password) }
    }

    fun updateName(name: String){
        _uiState.update { it.copy(name = name) }
    }

    fun updateConfirmPassword(password: String){
        _uiState.update { it.copy(confirmPassword = password) }
    }
}