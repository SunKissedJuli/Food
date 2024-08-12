package com.example.food.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@SuppressLint("UnrememberedMutableState")
@Composable
fun CategoryComponent(categoryName: String){
    val backgroundColor = MaterialTheme.colorScheme.background
    val background = remember { mutableStateOf(backgroundColor) }
    val backgroundClick = MaterialTheme.colorScheme.inversePrimary
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(55.dp)
            .shadow(5.dp, shape = RoundedCornerShape(30.dp))) {

        Box(Modifier.height(55.dp).clip(RoundedCornerShape(30.dp))
                .background(background.value)
                .clickable { background.value = backgroundClick }) {

            Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(5.dp))
                Box(
                    Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.onSecondary))
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = categoryName,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}