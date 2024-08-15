package com.example.food.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food.R

@Composable
fun ChooseOffers(buttonTexts: List<String> = listOf(stringResource(R.string.offer_delivery),
    stringResource(R.string.offer_pick_up), stringResource(R.string.offer), stringResource(R.string.offer_online_pay))) {
    val textColor = MaterialTheme.colorScheme.surfaceDim
    val borderColor = MaterialTheme.colorScheme.onSurfaceVariant
    val whiteColor = MaterialTheme.colorScheme.background
    val orangeColor = MaterialTheme.colorScheme.onPrimaryContainer


    Row(Modifier.fillMaxWidth()) {
        repeat(3) { index ->
            val isChosen = remember { mutableStateOf(false) }

            TextButton(
                onClick = { isChosen.value = !isChosen.value },
                modifier = Modifier
                    .background(
                        if (isChosen.value) orangeColor else whiteColor,
                        RoundedCornerShape(30.dp)
                    )
                    .border(
                        width = 2.dp, shape = RoundedCornerShape(30.dp),
                        color = if (isChosen.value) orangeColor else borderColor
                    )
                    .height(46.dp)) {
                Text(text = buttonTexts[index],
                    color = if (isChosen.value) whiteColor else textColor,
                    style = MaterialTheme.typography.titleLarge, fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }

    Row(Modifier.fillMaxWidth().padding(top = 10.dp)){

        val isChosen = remember { mutableStateOf(false) }
        TextButton(
            onClick = { isChosen.value = !isChosen.value },
            modifier = Modifier.background(
                if (isChosen.value) orangeColor else whiteColor,
                    RoundedCornerShape(30.dp))
                .border(width = 2.dp, shape = RoundedCornerShape(30.dp),
                    color = if (isChosen.value) orangeColor else borderColor)
                .height(46.dp)) {
            Text(text = buttonTexts[3],
                color = if (isChosen.value) whiteColor else textColor,
                style = MaterialTheme.typography.titleLarge, fontSize = 15.sp)
        }
        Spacer(modifier = Modifier.width(10.dp))
    }
}