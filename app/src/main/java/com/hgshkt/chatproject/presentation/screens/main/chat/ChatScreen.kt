package com.hgshkt.chatproject.presentation.screens.main.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.hgshkt.chatproject.R


@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    viewModel: ChatViewModel = hiltViewModel(),
    chatId: String
) {
    Box(modifier = modifier) {
        Column(modifier = Modifier.fillMaxSize()) {
            MessageList()
            MessageInput {
                viewModel.sendMessage(it)
            }
        }
    }
    LaunchedEffect(key1 = "fetch chat") {
        viewModel.fetchChat(chatId)
    }
}

@Composable
fun MessageInput(
    startText: String = "",
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
) {
    var enteredText by remember { mutableStateOf(startText) }

    Row(modifier) {
        TextField(value = enteredText, onValueChange = { enteredText = it })
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Send message button",
            modifier = Modifier.clickable {
                onClick(enteredText)
            }
        )
    }
}