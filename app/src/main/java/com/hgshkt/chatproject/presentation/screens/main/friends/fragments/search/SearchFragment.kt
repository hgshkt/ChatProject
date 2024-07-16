package com.hgshkt.chatproject.presentation.screens.main.friends.fragments.search

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.hgshkt.chatproject.presentation.screens.main.SearchField
import com.hgshkt.chatproject.presentation.screens.main.UserList

private const val placeholder = "Enter user name"

@Composable
fun SearchFragment(modifier: Modifier = Modifier) {
    var value by rememberSaveable {
        mutableStateOf("")
    }

    val users = emptyList()

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
            SearchUserItem()
        }
    }
}

@Composable
fun SearchUserItem(modifier: Modifier = Modifier) {

}