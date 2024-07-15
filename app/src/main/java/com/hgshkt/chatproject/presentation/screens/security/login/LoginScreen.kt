package com.hgshkt.chatproject.presentation.screens.security.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hgshkt.chatproject.presentation.app_navigation.Screen
import com.hgshkt.chatproject.presentation.screens.security.LinkToRegScreen
import com.hgshkt.chatproject.presentation.screens.security.LoginField
import com.hgshkt.chatproject.presentation.screens.security.PasswordField
import com.hgshkt.chatproject.presentation.screens.security.SubmitButton

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LoginField(
                value = login,
                onValueChange = { login = it },
                modifier = Modifier.fillMaxWidth()
            )
            PasswordField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            SubmitButton {
                viewModel.login(
                    login = login,
                    password = password
                )
                navController.navigate(Screen.Main.route)
            }
            LinkToRegScreen {
                navController.navigate(Screen.Security.Registration.route)
            }
        }
    }
}

@Preview()
@Composable
fun LoginScreenPreview() {
    val controller = rememberNavController()
    LoginScreen(controller)
}