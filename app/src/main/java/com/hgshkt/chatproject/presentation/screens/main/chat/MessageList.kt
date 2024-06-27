package com.hgshkt.chatproject.presentation.screens.main.chat

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun MessageList() {
    val messages = listOf<MessageUiModel>()
    LazyColumn {
        items(messages.size) {number ->
            Message(messages[number])
        }
    }
}