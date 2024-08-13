package com.example.food.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

@Composable
fun SizeBlock(sizes: List<String>){
    var firstBackground = MaterialTheme.colorScheme.secondaryContainer
    val chooseBackground = MaterialTheme.colorScheme.inversePrimary
    LazyRow(Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background)) {
        items(sizes.count()){
            var background by remember { mutableStateOf(firstBackground) }

            TextButton(shape = CircleShape,modifier = Modifier
                .size(55.dp)
                .background(background, CircleShape),
                onClick = {
                    if(background == firstBackground){ background = chooseBackground }
                    else{ background = firstBackground } }){

                Text(text = sizes.get(it), style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground)
            }
            Spacer(modifier = Modifier.width(15.dp))
        }
    }
}