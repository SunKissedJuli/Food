package com.example.food.Screen.Home

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.preferKeepClear
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.food.R
import com.example.food.components.CategoryComponent
import com.example.food.components.CustomSearchBar
import com.example.food.components.PopularFastfoodCard
import com.example.food.components.RestoranCard
import com.example.food.components.SuggesterRestaurantsItem
import com.example.food.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController){
    val viewModel: HomeViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(topBar = {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)) {

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp)){
                Text(text = stringResource(R.string.hello), style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onTertiary)
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = stringResource(R.string.good_afternoon), style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onTertiary)
            }

            CustomSearchBar(
                query = uiState.searchText, onQueryChange = {viewModel.updateSearchString(it)},
                onSearch = {viewModel.updateSearchContainer()},
                hint = stringResource(R.string.search_hint),
                leadingIcon =  {
                    Icon(painter = painterResource(id = R.drawable.icon_search),
                        contentDescription = "",
                        modifier = Modifier.padding(start = 5.dp),
                        tint = MaterialTheme.colorScheme.onSurface)}){

                Column(
                    Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)) {
                    Column(Modifier.padding(10.dp)) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = stringResource(R.string.search_resent),
                            style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.secondary)
                        Spacer(modifier = Modifier.height(10.dp))
                        LazyRow(Modifier.fillMaxWidth()) {
                            items(5){
                                Box(
                                    Modifier
                                        .height(50.dp)
                                        .clip(RoundedCornerShape(30.dp))
                                        .background(MaterialTheme.colorScheme.background)
                                        .border(
                                            width = 2.dp, shape = RoundedCornerShape(30.dp),
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )) {
                                    Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                                        Spacer(modifier = Modifier.width(15.dp))
                                        Text(text ="Hot Dog", style = MaterialTheme.typography.bodyMedium,
                                            color = MaterialTheme.colorScheme.secondary)
                                        Spacer(modifier = Modifier.width(15.dp))
                                    }
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Text(text = stringResource(R.string.suggested_rest),
                            style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.secondary)

                        Spacer(modifier = Modifier.height(5.dp))

                        Column(Modifier.fillMaxHeight(0.7f)) {
                            repeat(3){
                                Spacer(modifier = Modifier.height(10.dp))
                                SuggesterRestaurantsItem()
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = stringResource(R.string.search_popular),
                            style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.secondary)

                        Spacer(modifier = Modifier.height(10.dp))

                        LazyRow{
                            items(5){
                                PopularFastfoodCard()
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                        }

                    }
                }
            }
        }

        }
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(it)
                .background(MaterialTheme.colorScheme.background)) {

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp)) {

                //блок с категориями
                Row(Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                    Text(text = stringResource(R.string.categories),
                        style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.secondary)
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = stringResource(R.string.see_categories), style = MaterialTheme.typography.bodyLarge)
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(painter = painterResource(R.drawable.icon_go), contentDescription = "")
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(Modifier.fillMaxWidth()) {
                    items(5){
                        Spacer(modifier = Modifier.width(5.dp))
                        CategoryComponent(categoryName = "Hot Dog")
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                LazyColumn(Modifier.fillMaxWidth()) {
                    items(5){
                        Spacer(modifier = Modifier.height(5.dp))
                        RestoranCard(name = "Rose Garden Restaurant", description = "Burger - Chiken - Riche - Wings",
                            onClick = {navController.navigate(Screen.RestauranDetails.route)})
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}