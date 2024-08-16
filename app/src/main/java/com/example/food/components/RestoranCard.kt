package com.example.food.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.navigation.NavHostController
import com.example.food.R

@Composable
fun RestoranCard(
    name: String, description: String, onClick: ()->Unit = {},
    star: String = "4.7", deliveryCost: String = "Free", time: String = "20 min",
    background: Color = MaterialTheme.colorScheme.background,
    boxColor: Color = MaterialTheme.colorScheme.onSecondary ){
    Column(
        Modifier
            .fillMaxWidth()
            .background(background)
            .clickable { onClick() }) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(boxColor))

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = name, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onTertiary)
        Spacer(modifier = Modifier.height(7.dp))
        Text(text = description, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.tertiary)
        Spacer(modifier = Modifier.height(10.dp))

        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            Icon(painter = painterResource(R.drawable.icon_star), contentDescription = "",
                tint = MaterialTheme.colorScheme.primaryContainer)
            Text(text = star, style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onTertiary)
            Spacer(modifier = Modifier.width(20.dp))

            Icon(painter = painterResource(R.drawable.icon_car), contentDescription = "",
                tint = MaterialTheme.colorScheme.primaryContainer)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = deliveryCost, style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.onTertiary)
            Spacer(modifier = Modifier.width(20.dp))

            Icon(painter = painterResource(R.drawable.icon_time), contentDescription = "",
                tint = MaterialTheme.colorScheme.primaryContainer)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = time, style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.onTertiary)
        }

        Spacer(modifier = Modifier.height(10.dp))
    }
}