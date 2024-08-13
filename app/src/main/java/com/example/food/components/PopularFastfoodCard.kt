package com.example.food.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun PopularFastfoodCard(name: String = "European Pizza", description: String = "Uttora Coffe House"){

/* Box(modifier = Modifier
        .width(160.dp)
        .height(130.dp)
        .clip(RoundedCornerShape(10.dp))
        .shadow(15.dp, shape = RoundedCornerShape(10.dp))){*/

        Box(modifier = Modifier
         //   .align(Alignment.Center)
            .height(125.dp)
            .width(155.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.background)){

            Column(Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Box(Modifier
                        .width(130.dp)
                        .height(70.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.onSecondary)){}

                Spacer(modifier = Modifier.height(5.dp))
                Text(text = name, style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onTertiary)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = description, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(10.dp))
            }


        }
  //  }
}