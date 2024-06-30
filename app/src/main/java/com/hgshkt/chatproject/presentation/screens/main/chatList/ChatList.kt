package com.hgshkt.chatproject.presentation.screens.main.chatList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.hgshkt.chatproject.presentation.model.UiChat

@Composable
fun ChatList() {
    val list = listOf<UiChat>()

    LazyColumn {
        items(list.size) { number ->
            ChatItem(list[number])
        }
    }
}