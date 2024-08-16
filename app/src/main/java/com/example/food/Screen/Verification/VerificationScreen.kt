package com.example.food.Screen.Verification

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.food.R
import com.example.food.components.ButtonBack
import com.example.food.components.RoundedOrangeButton
import com.example.food.components.VerifyTextField
import com.example.food.navigation.Screen

@Composable
fun VerificationScreen(navController: NavHostController){
    val viewModel: VerificationViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground)) {

        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Text(text = stringResource(R.string.verification), style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.background)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(R.string.verification_text), style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.background)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = uiState.email, style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.background, fontWeight = FontWeight.Bold)
        }

        Box(
            Modifier
                .fillMaxSize()
                .align(Alignment.TopStart)){
            Row(Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Image(painter = painterResource(R.drawable.icon_black_ellipse),
                    modifier = Modifier.alpha(0.5f), contentDescription = "" )
                Icon(painter = painterResource(R.drawable.icon_broken_line), contentDescription = "",
                    tint = MaterialTheme.colorScheme.primaryContainer, modifier = Modifier.alpha(0.4f))

            }
        }

        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
                .background(MaterialTheme.colorScheme.background)) {


            Column(Modifier.padding(top = 30.dp, start = 30.dp, end = 30.dp)) {
                
                Row(Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = stringResource(R.string.code).uppercase(), style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.secondary)
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = stringResource(R.string.resend_code), style = MaterialTheme.typography.bodySmall)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))

                VerifyTextField(values = uiState.code, onValueChange = {newValue, isFilled ->
                viewModel.updateCode(newValue)})
                Spacer(modifier = Modifier.height(35.dp))

                RoundedOrangeButton(onClick = { navController.navigate(Screen.Home.route){
                    launchSingleTop = true
                    popUpTo(navController.graph.id){
                        inclusive = true } }},
                    buttonText = stringResource(R.string.verify),
                    modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }
    ButtonBack(onClick = {navController.navigate(Screen.Login.route)})
}
