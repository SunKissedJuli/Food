package com.example.food.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.food.R

@Composable
fun DetailsBlock(star: String, deliveryCost:String, time:String){
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
        Icon(painter = painterResource(R.drawable.icon_star), contentDescription = "",
            tint = MaterialTheme.colorScheme.primaryContainer)
        Text(text = star, style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onTertiary)
        Spacer(modifier = Modifier.width(20.dp))

        Icon(painter = painterResource(R.drawable.icon_car), contentDescription = "",
            tint = MaterialTheme.colorScheme.primaryContainer)
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = deliveryCost, style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.onTertiary)
        Spacer(modifier = Modifier.width(20.dp))

        Icon(painter = painterResource(R.drawable.icon_time), contentDescription = "",
            tint = MaterialTheme.colorScheme.primaryContainer)
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = time, style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.onTertiary)
    }
}