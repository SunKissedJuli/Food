package com.example.food.Screen.FoodDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.food.R
import com.example.food.components.ButtonBack
import com.example.food.components.ButtonFavorite
import com.example.food.components.ButtonMenu
import com.example.food.components.DetailsBlock
import com.example.food.components.OvalCounter
import com.example.food.components.RoundedOrangeButton
import com.example.food.components.SizeBlock
import com.example.food.navigation.Screen

@Composable
fun FoodDetailsScreen(navController: NavHostController){
    val viewModel: FoodDetailsViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        bottomBar = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer)){
                Column(Modifier.padding(top = 20.dp, start = 25.dp, end = 25.dp, bottom = 15.dp)) {
                    Row(Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically){
                        Text(text = stringResource(R.string.dollar) + uiState.cost,
                            style = MaterialTheme.typography.displayLarge,
                            color = MaterialTheme.colorScheme.onTertiary )
                        OvalCounter(
                            count = uiState.count,
                            onIncrement = { viewModel.updateCounterPlus() },
                            onDeIncrement = { viewModel.updateCounterMinus() })
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    
                    RoundedOrangeButton(onClick = { /*TODO*/ },
                        buttonText = stringResource(R.string.add_to_cart))
                }

            }
        }
    ) {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(it)
                .background(MaterialTheme.colorScheme.background)) {

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
                Text(text = uiState.name, style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))

                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(R.drawable.icon_rest), contentDescription = "",
                        Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = uiState.restName,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Medium
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                DetailsBlock(star = uiState.star, deliveryCost = uiState.deliveryCost, time = uiState.time)
                Spacer(modifier = Modifier.height(20.dp))

                Text(text = uiState.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.tertiary, fontWeight = FontWeight.Thin)
                Spacer(modifier = Modifier.height(20.dp))

                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                    Text(text = stringResource(R.string.size),
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onSurface)
                    Spacer(modifier = Modifier.width(15.dp))
                    SizeBlock(sizes =  listOf("10”", "14”", "18”"))
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = stringResource(R.string.ingredients).uppercase(),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.secondary)

                Spacer(modifier = Modifier.height(15.dp))

                Row(Modifier.fillMaxWidth()){
                    repeat(5){
                        Box(
                            Modifier
                                .size(55.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.surfaceVariant)){
                            Icon(painter = painterResource(R.drawable.icon_salt),
                                contentDescription = "",
                                modifier = Modifier.align(Alignment.Center),
                                tint = MaterialTheme.colorScheme.primaryContainer)
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                    }
                }


            }
        }
    }

    Box(
        Modifier
            .fillMaxSize()
            .padding(10.dp)){
        ButtonBack({navController.navigate(Screen.RestauranDetails.route)})
        ButtonFavorite(modifier = Modifier.align(Alignment.TopEnd))
    }
}