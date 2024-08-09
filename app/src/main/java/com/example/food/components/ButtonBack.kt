package com.example.food.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.food.R

@Composable
fun ButtonBack(onClick: ()->Unit){
    IconButton(onClick = onClick,
        modifier = Modifier.padding(top=15.dp, start = 10.dp).size(70.dp)) {
        Image(painter = painterResource(R.drawable.icon_back), contentDescription = "")
    }
}