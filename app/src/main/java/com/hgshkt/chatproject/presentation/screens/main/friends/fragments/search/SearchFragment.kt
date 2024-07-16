package com.hgshkt.chatproject.presentation.screens.main.friends.fragments.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.hgshkt.chatproject.presentation.data.model.UiUser
import com.hgshkt.chatproject.presentation.screens.main.SearchField
import com.hgshkt.chatproject.presentation.screens.main.UserList

private const val placeholder = "Enter user name"

@Composable
fun SearchFragment(modifier: Modifier = Modifier) {
    var value by rememberSaveable {
        mutableStateOf("")
    }

    val users = emptyList<UiUser>()

    Column {
        SearchField(
            placeholder = placeholder,
            value = value,
            onValueChange = { newValue ->
                value = newValue
            },
            onButtonClick = {
                // viewModel.searchButtonClick
            }
        )
        UserList(users = users) {
            AddButton {
                // viewModel.add()
            }
        }
    }
}

@Composable
fun AddButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(modifier = modifier, onClick = onClick) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add button")
    }
}