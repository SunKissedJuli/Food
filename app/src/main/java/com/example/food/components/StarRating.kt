package com.example.food.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.food.R

@Composable
fun StarRating(
    tintColor: Color = MaterialTheme.colorScheme.surfaceContainer,
    tintChooseColor: Color = MaterialTheme.colorScheme.surfaceBright ) {

    var rating by remember { mutableStateOf(0) }

    Row(Modifier.fillMaxWidth()) {
        repeat(5) { index ->
            val tint = if (index < rating) tintChooseColor else tintColor

            IconButton(
                onClick = { rating = index + 1 },
                modifier = Modifier
                    .border(width = 1.5.dp, shape = CircleShape,
                        color = MaterialTheme.colorScheme.onSurfaceVariant)
                    .size(48.dp)
                    .background(MaterialTheme.colorScheme.background)) {
                Icon(painter = painterResource(R.drawable.icon_filled_star),
                    contentDescription = "", tint = tint)
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}