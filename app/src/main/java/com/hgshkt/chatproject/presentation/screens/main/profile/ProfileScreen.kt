package com.hgshkt.chatproject.presentation.screens.main.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.hgshkt.chatproject.presentation.screens.main.ProfileUserName
import com.hgshkt.chatproject.presentation.screens.main.UserAvatar

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val url = ""
    val name = "Name"

    UserAvatar(url = url)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier.fillMaxHeight(0.25f)
        )
        UserAvatar(url = url)
        ProfileUserName(name = name)
    }
}