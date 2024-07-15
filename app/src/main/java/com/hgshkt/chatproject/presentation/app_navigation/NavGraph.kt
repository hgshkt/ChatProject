package com.hgshkt.chatproject.presentation.app_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.hgshkt.chatproject.presentation.screens.main.chat.ChatScreen
import com.hgshkt.chatproject.presentation.screens.main.chatList.ChatListScreen
import com.hgshkt.chatproject.presentation.screens.main.currentProfile.CurrentProfileScreen
import com.hgshkt.chatproject.presentation.screens.security.login.LoginScreen
import com.hgshkt.chatproject.presentation.screens.security.registration.RegistrationScreen

@Composable
fun NavGraph(
    controller: NavHostController
) {


    NavHost(navController = controller, startDestination = Screen.Main.route) {
        navigation(
            route = Screen.Main.route,
            startDestination = Screen.Main.CurrentProfile.route
        ) {
            composable(route = Screen.Main.CurrentProfile.route) {
                CurrentProfileScreen()
            }
            composable(route = Screen.Main.ChatList.route) {
                ChatListScreen()
            }
            composable(route = Screen.Main.Chat.route) {
                ChatScreen(chatId = "")
            }
            composable(route = Screen.Main.Profile.route) {
                ChatScreen(chatId = "")
            }
        }
        navigation(
            route = Screen.Security.route,
            startDestination = Screen.Security.Login.route
        ) {
            composable(route = Screen.Security.Login.route) {
                LoginScreen(controller)
            }
            composable(route = Screen.Security.Login.route) {
                RegistrationScreen(controller)
            }
        }
    }
}

sealed class Screen(val route: String) {
    data object Main: Screen("Main") {

        data object CurrentProfile: Screen("CurrentProfile")
        data object Profile: Screen("Profile")
        data object ChatList: Screen("ChatList")
        data object Chat: Screen("Chat")
    }
    data object Security: Screen("Security") {

        data object Login: Screen("Login")
        data object Registration: Screen("Registration")
    }
}