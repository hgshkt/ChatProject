package com.hgshkt.chatproject.presentation.screens.main.currentProfile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.hgshkt.chatproject.presentation.data.model.UiUser
import com.hgshkt.chatproject.presentation.data.model.UiUserSimpleData
import com.hgshkt.chatproject.presentation.screens.main.ProfileBackground
import com.hgshkt.chatproject.presentation.screens.main.ProfileUserName
import com.hgshkt.chatproject.presentation.screens.main.UserAvatar

@Composable
fun CurrentProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: CurrentProfileViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    val viewModelState: CurrentProfileViewModel.State = state.value

    when (viewModelState) {
        is CurrentProfileViewModel.State.Loading -> {
            LoadingScreenState()
        }
        is CurrentProfileViewModel.State.SimpleLoaded -> {
            SimpleScreenState(user = viewModelState.simpleData)
        }
        is CurrentProfileViewModel.State.Loaded -> {
            LoadedScreenState(user = viewModelState.user)
        }

        is CurrentProfileViewModel.State.Error -> {
            ErrorScreenState(viewModelState.message)
        }
    }


}

@Composable
private fun LoadingScreenState() {
    Text("Loading...")
}

@Composable
private fun ErrorScreenState(message: String) {
    Text(message)
}

@Composable
private fun LoadedScreenState(user: UiUser) {
    with(user) {
        ProfileBackground(url = backgroundUrl)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier.fillMaxHeight(0.25f)
            )
            UserAvatar(url = avatarUrl)
            ProfileUserName(name = name)
        }
    }
}

@Composable
private fun SimpleScreenState(user: UiUserSimpleData) {
    with(user) {
        ProfileBackground()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier.fillMaxHeight(0.25f)
            )
            UserAvatar(url = avatarUrl)
            ProfileUserName(name = name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    CurrentProfileScreen()
}