package com.hgshkt.chatproject.presentation.screens.security.registration

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hgshkt.chatproject.presentation.screens.security.LoginField
import com.hgshkt.chatproject.presentation.screens.security.PasswordField
import com.hgshkt.chatproject.presentation.screens.security.SubmitButton

@Composable
fun RegistrationScreen(
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
        }
    }
}

@Preview
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen()
}