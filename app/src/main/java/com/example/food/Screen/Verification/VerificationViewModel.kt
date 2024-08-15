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

    fun updateCode(index: Int, newValue: String) {
        if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
            _uiState.update { currentState ->
                val updatedCode = currentState.code.toMutableList().apply {
                    this[index] = newValue
                }
                currentState.copy(code = updatedCode)
            }
        }
    }
}