package com.example.food.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("UnrememberedMutableState")
@Composable
fun CategoryComponent(
    categoryName: String,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    backgroundClickColor: Color = MaterialTheme.colorScheme.inversePrimary,
    fontColor: Color = MaterialTheme.colorScheme.secondary,
    fontClickColor: Color = MaterialTheme.colorScheme.background,
    boxColor: Color = MaterialTheme.colorScheme.onSecondary){

    val isChosen = remember { mutableStateOf(false) }

    Box(modifier = Modifier
            .width(120.dp)
            .height(55.dp)
            .shadow(5.dp, shape = RoundedCornerShape(30.dp))) {

        Box(Modifier.height(55.dp).clip(RoundedCornerShape(30.dp))
                .background(if (isChosen.value) backgroundClickColor else backgroundColor)
                .clickable { isChosen.value = !isChosen.value }) {

            Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(5.dp))
                Box(Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .background(boxColor))
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = categoryName, style = MaterialTheme.typography.bodyMedium,
                    color = if (isChosen.value) fontClickColor else fontColor)
            }
        }
    }
}