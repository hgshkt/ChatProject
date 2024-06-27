package com.hgshkt.chatproject.presentation.screens.security.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hgshkt.chatproject.presentation.navigation.Screen
import com.hgshkt.chatproject.presentation.screens.security.LinkToLoginScreen
import com.hgshkt.chatproject.presentation.screens.security.LoginField
import com.hgshkt.chatproject.presentation.screens.security.PasswordField
import com.hgshkt.chatproject.presentation.screens.security.SubmitButton

@Composable
fun RegistrationScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            LoginField(value = login, onValueChange = { login = it })
            PasswordField(value = password, onValueChange = { password = it })
            Spacer(modifier = Modifier.height(10.dp))
            SubmitButton(text = "Registration") {
                // viewModel.register()
            }
            LinkToLoginScreen {
                navController.navigate(Screen.Security.Login.route)
            }
        }
    }
}

@Preview
@Composable
fun RegistrationScreenPreview() {
    val controller = rememberNavController()
    RegistrationScreen(controller)
}