package com.example.food.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.food.R

@Composable
fun ButtonBack(onClick: ()->Unit, background: Color = MaterialTheme.colorScheme.secondary,
               tint: Color = MaterialTheme.colorScheme.background, modifier: Modifier = Modifier){
    IconButton(onClick = onClick,
        modifier = modifier.size(45.dp)) {
        Row(Modifier.size(45.dp).clip(CircleShape)
            .background(background),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Icon(painter = painterResource(id = R.drawable.icon_back),
                contentDescription = "",
                tint = tint)
        }
    }
}