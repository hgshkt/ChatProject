package com.hgshkt.chatproject.presentation.screens.main.friends.fragments.search

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hgshkt.chatproject.presentation.data.model.UiUser
import com.hgshkt.chatproject.presentation.screens.main.friends.UserListSearchable

private const val placeholder = "Enter user name"

@Composable
fun SearchFragment() {
    val users = emptyList<UiUser>()

    UserListSearchable(
        users = users,
        onSearchButtonClick = { string ->
            // viewModel.search(string)
        },
        placeholder = placeholder
    ) {
        AddButton {
            // viewModel.add()
        }
    }
}

@Composable
fun AddButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(modifier = modifier, onClick = onClick) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add button")
    }
}