package com.example.food.Screen.Login

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.example.food.components.RoundedGrayTextField
import com.example.food.components.RoundedOrangeButton
import com.example.food.navigation.Screen

@Composable
fun LoginScreen(navController: NavHostController){
    val viewModel: LoginViewModel = viewModel()
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
            Text(text = stringResource(R.string.login), style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.background)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(R.string.please_login), style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.background)
        }

        Box(Modifier.fillMaxSize().align(Alignment.TopStart)){

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Image(painter = painterResource(R.drawable.icon_black_ellipse),
                    modifier = Modifier.alpha(0.5f), contentDescription = "" )
                Image(painter = painterResource(R.drawable.icon_broken_line), contentDescription = "" )
            }
        }

        Box(Modifier.fillMaxWidth().align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
                .background(MaterialTheme.colorScheme.background)) {

            Column(Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp)) {
                Text(text = stringResource(R.string.email), style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary)

                RoundedGrayTextField(value = uiState.email, placeholder = stringResource(R.string.email_example),
                    onValueChange = viewModel::updateEmail,
                    modifier = Modifier.align(Alignment.CenterHorizontally))

                Spacer(modifier = Modifier.height(25.dp))
                Text(text = stringResource(R.string.password), style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary)

                RoundedGrayTextField(value = uiState.password, placeholder = stringResource(R.string.password_mask),
                    onValueChange = viewModel::updatePassword,
                    modifier = Modifier.align(Alignment.CenterHorizontally))

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
                        Checkbox(checked = false, onCheckedChange = {},
                           colors = CheckboxColors(checkedBorderColor = MaterialTheme.colorScheme.tertiary,
                               uncheckedBorderColor = MaterialTheme.colorScheme.tertiary,
                               checkedBoxColor = MaterialTheme.colorScheme.background,
                               uncheckedBoxColor = MaterialTheme.colorScheme.background,
                               disabledBorderColor = MaterialTheme.colorScheme.tertiary,
                               disabledIndeterminateBorderColor = MaterialTheme.colorScheme.tertiary,
                               disabledUncheckedBorderColor = MaterialTheme.colorScheme.tertiary,
                               disabledCheckedBoxColor = MaterialTheme.colorScheme.background,
                               disabledUncheckedBoxColor = MaterialTheme.colorScheme.background,
                               disabledIndeterminateBoxColor = MaterialTheme.colorScheme.tertiary,
                               checkedCheckmarkColor = MaterialTheme.colorScheme.tertiary,
                               uncheckedCheckmarkColor = MaterialTheme.colorScheme.tertiary))
                        Text(text = stringResource(R.string.remember_me), style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.tertiary)
                    }

                    TextButton(onClick = { navController.navigate(Screen.ForgotPassword.route) }) {
                        Text(text = stringResource(R.string.forgot_password),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primaryContainer)
                    }
                }

                RoundedOrangeButton(onClick = {navController.navigate(Screen.Verification.route)},
                    buttonText = stringResource(R.string.login),
                    modifier = Modifier.align(Alignment.CenterHorizontally))

                Row(Modifier.fillMaxWidth()
                        .padding(top = 15.dp, bottom = 5.dp), horizontalArrangement = Arrangement.Center){
                    TextButton(onClick = { navController.navigate(Screen.Registration.route) }) {
                        Text(text = stringResource(R.string.no_account),
                            style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSecondary)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = stringResource(R.string.sign_up).uppercase(),
                            style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primaryContainer)
                    }
                }

                Text(text = stringResource(R.string.or), modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSecondary)

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly){

                    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(70.dp)) {
                        Image(painter = painterResource(R.drawable.icon_facebook),
                           contentDescription = "") }

                    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(70.dp)) {
                        Image(painter = painterResource(R.drawable.icon_twitter), contentDescription = "") }

                    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(70.dp)) {
                        Image(painter = painterResource(R.drawable.icon_apple), contentDescription = "") }
                }
            }
        }
    }
}