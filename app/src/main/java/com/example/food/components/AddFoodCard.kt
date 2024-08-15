package com.example.food.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.food.R

@Composable
fun AddFoodCard(onClick: ()->Unit, name: String = "European Pizza",
                description: String = "Uttora Coffe House", cost: String = "\$40"){

    Box(Modifier.fillMaxWidth().
    background(Color.Transparent)
        .padding(10.dp)
        .height(180.dp).shadow(15.dp, shape = RoundedCornerShape(10.dp))
        .offset(x = 0.dp, y = 0.dp)){

        Box(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .height(175.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.background)
                .clickable { onClick() }) {

            Column(Modifier.fillMaxSize()
                    .padding(top = 10.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
                verticalArrangement = Arrangement.Center) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Box(Modifier
                            .width(110.dp)
                            .height(70.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.onSecondary))
                }

                Spacer(modifier = Modifier.height(5.dp))
                Text(text = name,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onTertiary
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = description, maxLines = 1,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.tertiary
                )

                Row(Modifier.fillMaxWidth().padding(top = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {

                    Text(text = cost,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onTertiary)
                    IconButton(onClick = {}, modifier = Modifier.size(30.dp)) {
                        Image(painter = painterResource(R.drawable.icon_plus),
                            modifier = Modifier.size(30.dp), contentDescription = "")
                    }
                }
            }
        }
    }
}