package com.hgshkt.chatproject.presentation.screens.main.chat

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.hgshkt.chatproject.presentation.data.model.UiMessage

@Composable
fun MessageList() {
    val messages = listOf<UiMessage>()
    LazyColumn {
        items(messages.size) {number ->
            Message(messages[number])
        }
    }
}