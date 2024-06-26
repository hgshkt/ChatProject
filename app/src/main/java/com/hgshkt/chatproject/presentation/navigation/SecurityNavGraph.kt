package com.hgshkt.chatproject.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hgshkt.chatproject.presentation.screens.security.login.LoginScreen
import com.hgshkt.chatproject.presentation.screens.security.registration.RegistrationScreen
import com.hgshkt.chatproject.presentation.navigation.SecurityScreen.*

@Composable
fun SecurityNavGraph() {
    val controller = rememberNavController()

    NavHost(navController = controller, startDestination = Login.route) {
        composable(Login.route) {
            LoginScreen(controller)
        }
        composable(Registration.route) {
            RegistrationScreen()
        }
    }
}

sealed class SecurityScreen(val route: String) {
    data object Login: SecurityScreen("Login")
    data object Registration: SecurityScreen("Registration")
}