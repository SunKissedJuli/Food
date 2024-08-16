package com.example.food.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.food.R

@Composable
fun SuggesterRestaurantsItem(
    name: String = "Pansi Restaurant", star: String = "4.7",
    background: Color = MaterialTheme.colorScheme.background,
    boxColor: Color = MaterialTheme.colorScheme.onSecondary,
    tintColor: Color = MaterialTheme.colorScheme.primaryContainer,
    lineColor: Color = MaterialTheme.colorScheme.onSurface){

    Column(Modifier.fillMaxWidth().height(80.dp).background(background)) {

        Row(Modifier.fillMaxWidth().height(60.dp),
            verticalAlignment = Alignment.CenterVertically){

            Box(Modifier.height(55.dp).width(70.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(boxColor))
            Spacer(modifier = Modifier.width(20.dp))

            Column {
                Text(text = name, style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.secondary)

                Spacer(modifier = Modifier.height(7.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Icon(painter = painterResource(R.drawable.icon_star), contentDescription = "",
                        tint = tintColor)
                    Text(text = star, style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onTertiary)
                }
            }
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 5.dp)
            .height(1.dp)
            .background(color = lineColor)
        )
    }

}