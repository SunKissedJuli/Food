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
import androidx.compose.ui.unit.dp
@Composable
fun SizeBlock(sizes: List<String>) {
    val firstBackground = MaterialTheme.colorScheme.secondaryContainer
    val chooseBackground = MaterialTheme.colorScheme.onPrimaryContainer
    val firstTextColor = MaterialTheme.colorScheme.onBackground
    val chooseTextColor = MaterialTheme.colorScheme.background

    var selectedButtonIndex by remember { mutableStateOf(-1) }

    Row(Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background)) {
        repeat(sizes.size) { index ->
            val isChosen = selectedButtonIndex == index
            val background = if (isChosen) chooseBackground else firstBackground
            val text = if (isChosen) chooseTextColor else firstTextColor

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