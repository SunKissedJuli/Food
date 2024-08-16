package com.example.food.Screen.Verification

import androidx.lifecycle.ViewModel
import com.example.food.Screen.Registration.RegistrationUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class VerificationViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(VerificationUiState())
    val uiState: StateFlow<VerificationUiState> = _uiState.asStateFlow()

    fun updateCode(newValue: String) {
        _uiState.value = _uiState.value.copy(code = newValue)
    }
}