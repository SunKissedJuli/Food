package com.example.food.Screen.RestaurantDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.food.R
import com.example.food.components.AddFoodCard
import com.example.food.components.ButtonBack
import com.example.food.components.ButtonMenu
import com.example.food.components.CategoryComponent
import com.example.food.components.RestaurantComponentChoose
import com.example.food.navigation.Screen

@Composable
fun RestaurantDetailsScreen(navController: NavHostController){
    val viewModel: RestaurantDetailsViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)) {
        item{
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                    .background(MaterialTheme.colorScheme.onSecondary))


            Column(
                Modifier
                    .fillMaxSize()
                    .padding(20.dp)) {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                    Icon(painter = painterResource(R.drawable.icon_star), contentDescription = "",
                        tint = MaterialTheme.colorScheme.primaryContainer)
                    Text(text = uiState.star, style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onTertiary)
                    Spacer(modifier = Modifier.width(20.dp))

                    Icon(painter = painterResource(R.drawable.icon_car), contentDescription = "",
                        tint = MaterialTheme.colorScheme.primaryContainer)
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = uiState.deliveryCost, style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.onTertiary)
                    Spacer(modifier = Modifier.width(20.dp))

                    Icon(painter = painterResource(R.drawable.icon_time), contentDescription = "",
                        tint = MaterialTheme.colorScheme.primaryContainer)
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = uiState.time, style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.onTertiary)
                }
                Spacer(modifier = Modifier.height(20.dp))

                Text(text = uiState.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(15.dp))
                Text(text = uiState.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.tertiary, fontWeight = FontWeight.Thin)

                Spacer(modifier = Modifier.height(20.dp))

                LazyRow(Modifier.fillMaxWidth()) {
                    items(5){
                        Spacer(modifier = Modifier.width(5.dp))
                        RestaurantComponentChoose(categoryName = "Burger")
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
        }

        items(5){
            Row(Modifier.fillMaxWidth()){
                Column(Modifier.fillMaxWidth(0.5f)) {
                    AddFoodCard()
                }
                AddFoodCard()
            }
            Spacer(modifier = Modifier.height(5.dp))
        }





    }
    Box(
        Modifier
            .fillMaxSize()
            .padding(10.dp)){
        ButtonBack({navController.navigate(Screen.Home.route)})
        ButtonMenu(modifier = Modifier.align(Alignment.TopEnd))
    }
}