package com.hgshkt.chatproject.presentation.screens.main.friends.fragments.friends

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hgshkt.chatproject.presentation.data.model.UiUser
import com.hgshkt.chatproject.presentation.screens.main.friends.UserListSearchable

private const val placeholder = "Enter user name"

@Composable
fun FriendsFragment() {
    val users = emptyList<UiUser>()

    UserListSearchable(
        users = users,
        onSearchButtonClick = { string ->
            // viewModel.search(string)
        },
        placeholder = placeholder
    ) {
        DeleteButton {
            // viewModel.add()
        }
    }
}

@Composable
fun DeleteButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(modifier = modifier, onClick = onClick) {
        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete button")
    }
}