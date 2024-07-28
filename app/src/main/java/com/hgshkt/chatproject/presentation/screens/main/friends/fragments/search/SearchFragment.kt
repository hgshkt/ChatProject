package com.hgshkt.chatproject.presentation.screens.main.friends.fragments.search

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.hgshkt.chatproject.presentation.screens.main.friends.FriendsViewModel
import com.hgshkt.chatproject.presentation.screens.main.friends.UserListSearchable

private const val placeholder = "Enter user name"

@Composable
fun SearchFragment(
    viewModel: FriendsViewModel = hiltViewModel()
) {
    val users = viewModel.usersFlow.collectAsState()

    UserListSearchable(
        users = users.value,
        onSearchButtonClick = { string ->
            // viewModel.search(string)
        },
        placeholder = placeholder
    ) {
        AddButton {
            // viewModel.add()
        }
    }
    LaunchedEffect(key1 = "view model fetch users") {
        viewModel.fetchUsers()
    }
}

@Composable
fun AddButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(modifier = modifier, onClick = onClick) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add button")
    }
}