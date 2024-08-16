package com.example.food.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable
fun SizeBlock(
    sizes: List<String>,
    background: Color = MaterialTheme.colorScheme.secondaryContainer,
    chooseBackground: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    chooseTextColor: Color = MaterialTheme.colorScheme.background) {

    var selectedButtonIndex by remember { mutableStateOf(-1) }

    Row(Modifier.fillMaxWidth()) {
        repeat(sizes.size) { index ->
            val isChosen = selectedButtonIndex == index
            val background = if (isChosen) chooseBackground else background
            val text = if (isChosen) chooseTextColor else textColor

            TextButton(onClick = { selectedButtonIndex = index },
                modifier = Modifier.size(48.dp)
                    .background(background, CircleShape)) {
                Text(text = sizes[index],
                    style = MaterialTheme.typography.titleLarge,
                    color = text)
            }
            Spacer(modifier = Modifier.width(15.dp))
        }
    }
}