package com.hgshkt.chatproject.presentation.screens.main.friends.fragments.search

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import com.hgshkt.chatproject.presentation.data.model.UiUserSimpleData
import com.hgshkt.chatproject.presentation.screens.main.friends.FriendsViewModel
import com.hgshkt.chatproject.presentation.screens.main.friends.UserListSearchable

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
                    onSearchButtonClick = { query ->
                        viewModel.search(query)
                    },
                    addButtonClick = { user ->
                        viewModel.sendInvite(user.id)
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
    addButtonClick: (user: UiUserSimpleData) -> Unit
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
    val state = remember { mutableStateOf(AddButton.DEFAULT) }
    IconButton(
        modifier = modifier,
        onClick = {
            onClick()
            state.value = AddButton.ADDED
        }
    ) {
        Icon(imageVector = state.value.icon, contentDescription = "Add button")
    }
}

private enum class AddButton(val icon: ImageVector) {
    DEFAULT(Icons.Default.Add),
    ADDED(Icons.Default.Done)
}