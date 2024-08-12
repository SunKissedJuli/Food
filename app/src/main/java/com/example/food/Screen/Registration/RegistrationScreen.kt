package com.example.food.Screen.Registration

import android.annotation.SuppressLint
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.food.R
import com.example.food.components.ButtonBack
import com.example.food.components.RoundedGrayTextField
import com.example.food.components.RoundedOrangeButton
import com.example.food.navigation.Screen

@Composable
fun RegistrationScreen(navController: NavHostController){
    val viewModel: RegistrationViewModel = viewModel()
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
            Text(text = stringResource(R.string.sign_up), style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.background)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(R.string.please_sign_up), style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.background)
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
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
                .background(MaterialTheme.colorScheme.background)) {

            Column(Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp)) {
                Text(text = stringResource(R.string.name), style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary)
                RoundedGrayTextField(value = uiState.name, placeholder = stringResource(R.string.name_placeholder),
                    onValueChange = viewModel::updateName,
                    modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(25.dp))

                Text(text = stringResource(R.string.email), style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary)
                RoundedGrayTextField(value = uiState.email, placeholder = stringResource(R.string.password_mask),
                    onValueChange = viewModel::updateEmail,
                    modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(25.dp))

                Text(text = stringResource(R.string.password), style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary)
                RoundedGrayTextField(value = uiState.password, placeholder = stringResource(R.string.password_mask),
                    onValueChange = viewModel::updatePassword,
                    modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(25.dp))

                Text(text = stringResource(R.string.password_confirm).uppercase(), style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary)
                RoundedGrayTextField(value = uiState.confirmPassword, placeholder = stringResource(R.string.password_mask),
                    onValueChange = viewModel::updateConfirmPassword,
                    modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(25.dp))

                RoundedOrangeButton(onClick = {navController.navigate(Screen.Verification.route)}, buttonText = stringResource(R.string.sign_up),
                    modifier = Modifier.align(Alignment.CenterHorizontally))

            }
        }
    }
    ButtonBack(onClick = {navController.navigate(Screen.Login.route)})
}