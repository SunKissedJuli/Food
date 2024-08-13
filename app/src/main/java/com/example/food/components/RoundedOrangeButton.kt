package com.example.food.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RoundedOrangeButton(onClick: ()-> Unit, buttonText: String, modifier: Modifier = Modifier){
    Button(onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.fillMaxWidth().height(62.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer)) {
        Text(text = buttonText.uppercase(), color = MaterialTheme.colorScheme.background,
            style = MaterialTheme.typography.bodyMedium)
    }
}