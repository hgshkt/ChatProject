package com.hgshkt.chatproject.presentation.screens.main.friends

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

private const val placeholder = "Enter user name"

@Composable
fun FriendsFragment(
    viewModel: FriendsViewModel = hiltViewModel()
) {
    val friends = viewModel.friendsFlow.collectAsState()

    UserListSearchable(
        users = friends.value,
        onSearchButtonClick = { string ->
            viewModel.filterFriends(string)
        },
        placeholder = placeholder
    ) { user ->
        DeleteButton {
            viewModel.delete(user.id)
        }
    }
    LaunchedEffect(key1 = "view model fetch friends") {
        viewModel.fetchFriends()
    }
}

@Composable
fun DeleteButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(modifier = modifier, onClick = onClick) {
        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete button")
    }
}