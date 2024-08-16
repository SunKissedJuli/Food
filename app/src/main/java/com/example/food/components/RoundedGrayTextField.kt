package com.example.food.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RoundedGrayTextField(
    value: String,
    placeholder: String,
    onValueChange:(String)->Unit,
    modifier: Modifier = Modifier,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        focusedTextColor = MaterialTheme.colorScheme.secondary,
        unfocusedTextColor = MaterialTheme.colorScheme.secondary,
        unfocusedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
        focusedBorderColor = MaterialTheme.colorScheme.secondaryContainer),
    placeholderColor: Color = MaterialTheme.colorScheme.tertiary){

    OutlinedTextField(
        value = value,
        onValueChange = {onValueChange(it)},
        modifier.fillMaxWidth().padding(top = 10.dp),
        shape = RoundedCornerShape(15.dp),
        colors = colors,
        placeholder = { Text(text = placeholder, color = placeholderColor) })
}