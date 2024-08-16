package com.example.food.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food.R

@Composable
fun ChooseDelivery(
    buttonTexts: List<String> = listOf(stringResource(R.string.delivery_short),
    stringResource(R.string.delivery_medium), stringResource(R.string.delivery_long)),
    textColor: Color = MaterialTheme.colorScheme.surfaceDim,
    textChooseColor: Color = MaterialTheme.colorScheme.background,
    borderColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    borderChooseColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    backgroundChooseColor: Color = MaterialTheme.colorScheme.onPrimaryContainer) {



    var selectedButtonIndex by remember { mutableStateOf(-1) }

    Row(Modifier.fillMaxWidth()) {
        repeat(3) { index ->
            val isChosen = selectedButtonIndex == index

            TextButton(
                onClick = { selectedButtonIndex = index },
                modifier = Modifier.background(
                    if (isChosen) backgroundChooseColor else backgroundColor,
                    RoundedCornerShape(30.dp))
                    .border(width = 2.dp, shape = RoundedCornerShape(30.dp),
                        color = if (isChosen) borderChooseColor else borderColor)
                    .height(46.dp)) {
                Text(text = buttonTexts[index],
                    color = if (isChosen) textChooseColor else textColor,
                    style = MaterialTheme.typography.titleLarge, fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}