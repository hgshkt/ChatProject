package com.hgshkt.chatproject.presentation.screens.main.chatList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun ChatList() {
    val list = listOf<ChatListUiModel>()

    LazyColumn {
        items(list.size) { number ->
            ChatItem(list[number])
        }
    }
}