package com.hgshkt.chatproject.presentation.screens.main.chatList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.hgshkt.chatproject.presentation.data.model.UiChat

@Composable
fun ChatListScreen(
    modifier: Modifier = Modifier,
    viewModel: ChatListViewModel = hiltViewModel()
) {
    val list = listOf<UiChat>()

    LazyColumn {
        items(list.size) { number ->
            ChatItem(list[number])
        }
    }
}