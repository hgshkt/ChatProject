package com.hgshkt.chatproject.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {
    val controller = rememberNavController()

    NavHost(navController = controller, startDestination = Screen.Main.route) {
        navigation(
            route = Screen.Main.route,
            startDestination = Screen.Main.Profile.route
        ) {

        }
        navigation(
            route = Screen.Security.route,
            startDestination = Screen.Security.Login.route
        ) {

        }
    }
}

sealed class Screen(val route: String) {
    data object Main: Screen("Main") {
        data object Profile: Screen("Profile")
        data object ChatList: Screen("ChatList")
        data object Chat: Screen("Chat")
    }
    data object Security: Screen("Security") {
        data object Login: Screen("Login")
        data object Registration: Screen("Registration")
    }
}