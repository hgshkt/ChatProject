package com.hgshkt.chatproject.presentation.screens.security

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun LoginField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Login",
    placeholder: String = "Enter login"
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        singleLine = true
    )
}

@Composable
fun PasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Password",
    placeholder: String = "Enter password"
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun NameField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Name",
    placeholder: String = "Enter name"
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        singleLine = true
    )
}

@Composable
fun SubmitButton(
    modifier: Modifier = Modifier,
    text: String = "Submit",
    onCLick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        onClick = onCLick
    ) {
        Text(text)
    }
}

var linkToRegText = "To registration screen"

@Composable
fun LinkToRegScreen(
    text: String = linkToRegText,
    modifier: Modifier = Modifier,
    onCLick: () -> Unit
) {
    Text(text, modifier = modifier.clickable {
        onCLick()
    })
}

var linkToLoginText = "To login screen"

@Composable
fun LinkToLoginScreen(
    modifier: Modifier = Modifier,
    text: String = linkToLoginText,
    onCLick: () -> Unit
) {
    Text(text, modifier = modifier.clickable {
        onCLick()
    })
}