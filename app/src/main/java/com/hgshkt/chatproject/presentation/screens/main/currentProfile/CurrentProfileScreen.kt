package com.hgshkt.chatproject.presentation.screens.main.currentProfile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hgshkt.chatproject.presentation.screens.main.ProfileBackground
import com.hgshkt.chatproject.presentation.screens.main.ProfileUserName
import com.hgshkt.chatproject.presentation.screens.main.UserAvatar

@Composable
fun CurrentProfileScreen() {
    val url = ""
    val name = "Name"

    ProfileBackground(url = url)
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

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    CurrentProfileScreen()
}