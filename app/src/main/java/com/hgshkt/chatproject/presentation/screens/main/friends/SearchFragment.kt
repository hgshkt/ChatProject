package com.hgshkt.chatproject.presentation.screens.main.friends

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.hgshkt.chatproject.presentation.data.model.UiUserSimpleData

private const val placeholder = "Enter user name"

@Composable
fun SearchFragment(
    viewModel: FriendsViewModel = hiltViewModel()
) {
    val state = viewModel.searchFragmentState.collectAsState()

    state.value.apply {
        when (this) {
            is FriendsViewModel.State.Loading -> {
                LoadingScreenState()
            }

            is FriendsViewModel.State.Success -> {
                SuccessScreenState(
                    users = users,
                    onSearchButtonClick = {query ->
                        viewModel.search(query)
                    },
                    addButtonClick = { user ->
                        viewModel.sendFriendRequest(user.id)
                    }
                )
            }

            is FriendsViewModel.State.Error -> {
                ErrorScreenState(message)
            }
        }
    }

    LaunchedEffect(key1 = "view model fetch users") {
        viewModel.fetchUsers()
    }
}

@Composable
fun ErrorScreenState(message: String) {
    Text(message)
}

@Composable
fun SuccessScreenState(
    users: List<UiUserSimpleData>,
    onSearchButtonClick: (String) -> Unit,
    addButtonClick: (UiUserSimpleData) -> Unit
) {
    UserListSearchable(
        users = users,
        onSearchButtonClick = { string ->
            onSearchButtonClick(string)
        },
        placeholder = placeholder
    ) { user ->
        AddButton {
            addButtonClick(user)
        }
    }
}

@Composable
fun LoadingScreenState() {
    Text("Loading...")
}

@Composable
fun AddButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(modifier = modifier, onClick = onClick) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add button")
    }
}