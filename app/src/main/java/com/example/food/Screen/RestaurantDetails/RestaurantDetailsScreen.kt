package com.example.food.Screen.RestaurantDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.food.R
import com.example.food.components.AddFoodCard
import com.example.food.components.ButtonBack
import com.example.food.components.ButtonMenu
import com.example.food.components.ChooseDelivery
import com.example.food.components.ChooseOffers
import com.example.food.components.ChoosePrising
import com.example.food.components.DetailsBlock
import com.example.food.components.RestaurantComponentChoose
import com.example.food.components.RoundedOrangeButton
import com.example.food.components.StarRating
import com.example.food.navigation.Screen

@Composable
fun RestaurantDetailsScreen(navController: NavHostController){
    val viewModel: RestaurantDetailsViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    if(uiState.isFilterDialog){
        FilterDialog({viewModel.showFilterDialog()})
    }

    Scaffold(
        topBar = {
            Row(Modifier.fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween){

                Row(Modifier.padding(end = 20.dp, top = 10.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Row(Modifier.padding(start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically){
                        ButtonBack(onClick = { navController.navigate(Screen.Home.route){
                            launchSingleTop = true
                            popUpTo(navController.graph.id){ inclusive = true } }},
                            background = MaterialTheme.colorScheme.onTertiaryContainer,
                            tint = MaterialTheme.colorScheme.onTertiary,
                            modifier = Modifier.padding(end = 15.dp))

                        Text(text = stringResource(R.string.rest_view),
                            style = MaterialTheme.typography.displayMedium,
                            color = MaterialTheme.colorScheme.onTertiary)
                    }

                    ButtonMenu({viewModel.showFilterDialog()},
                        modifier = Modifier.padding(end = 10.dp),
                        background = MaterialTheme.colorScheme.onTertiaryContainer,
                        tint = MaterialTheme.colorScheme.onTertiary)
                }

            }
        }
    ) {
        LazyColumn(
            Modifier
                .padding(it)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)) {
            item{
                /*  ImageViewer(listOf(painterResource(R.drawable.icon_restoran_image), painterResource(R.drawable.icon_restoran_image),
                      painterResource(R.drawable.icon_restoran_image), painterResource(R.drawable.icon_restoran_image),
                      painterResource(R.drawable.icon_restoran_image)))*/
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(MaterialTheme.colorScheme.onSecondary))

                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(20.dp)) {

                    Text(text = uiState.name,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.secondary, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(text = uiState.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.tertiary, fontWeight = FontWeight.Thin)
                    Spacer(modifier = Modifier.height(20.dp))

                    DetailsBlock(star = uiState.star, deliveryCost = uiState.deliveryCost, time = uiState.time)
                    Spacer(modifier = Modifier.height(20.dp))

                    LazyRow(Modifier.fillMaxWidth()) {
                        items(5){
                            Spacer(modifier = Modifier.width(5.dp))
                            RestaurantComponentChoose(categoryName = stringResource(R.string.burger))
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(25.dp))

                    Text(text =stringResource(R.string.burger_10),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.secondary, fontWeight = FontWeight.Normal)
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }

            items(5){
                Row(Modifier.fillMaxWidth()){
                    Column(Modifier.fillMaxWidth(0.5f)) {
                        AddFoodCard({navController.navigate(Screen.FoodDetails.route)})
                    }
                    AddFoodCard({navController.navigate(Screen.FoodDetails.route)})
                }
                Spacer(modifier = Modifier.height(5.dp))
            }

        }
    }
}

@Composable
private fun FilterDialog(onDismissRequest: ()->Unit){
    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.background)){
            Column(Modifier.padding(20.dp)) {
                Row(Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = stringResource(R.string.filer_head),
                        style = MaterialTheme.typography.displayMedium,
                        color = MaterialTheme.colorScheme.onTertiary)

                    IconButton(onClick = onDismissRequest,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.onTertiaryContainer)) {
                        Image(painter = painterResource(R.drawable.icon_exit),
                            contentDescription = "")
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))

                Text(text =stringResource(R.string.filer_offers).uppercase(),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary)
                Spacer(modifier = Modifier.height(10.dp))
                ChooseOffers()
                Spacer(modifier = Modifier.height(15.dp))

                Text(text =stringResource(R.string.filer_time).uppercase(),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary)
                Spacer(modifier = Modifier.height(10.dp))
                ChooseDelivery()
                Spacer(modifier = Modifier.height(15.dp))

                Text(text =stringResource(R.string.filer_prise).uppercase(),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary)
                Spacer(modifier = Modifier.height(10.dp))
                ChoosePrising()
                Spacer(modifier = Modifier.height(15.dp))

                Text(text =stringResource(R.string.filer_rating).uppercase(),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary)
                Spacer(modifier = Modifier.height(10.dp))
                StarRating()

                Spacer(modifier = Modifier.height(25.dp))

                RoundedOrangeButton(onClick = {onDismissRequest() },
                    buttonText = stringResource(R.string.filer))
            }
        }
    }
}