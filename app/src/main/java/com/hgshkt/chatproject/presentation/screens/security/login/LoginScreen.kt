package com.hgshkt.chatproject.presentation.screens.security.login

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hgshkt.chatproject.presentation.navigation.SecurityScreen
import com.hgshkt.chatproject.presentation.screens.security.LinkToRegScreen
import com.hgshkt.chatproject.presentation.screens.security.LoginField
import com.hgshkt.chatproject.presentation.screens.security.PasswordField
import com.hgshkt.chatproject.presentation.screens.security.SubmitButton

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier
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
                // viewModel.login()
            }
            LinkToRegScreen {
                navController.navigate(SecurityScreen.Registration.route)
            }
        }
    }
}

@Preview()
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}