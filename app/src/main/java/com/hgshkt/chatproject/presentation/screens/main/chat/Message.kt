package com.hgshkt.chatproject.presentation.screens.main.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OutputMessage(
    message: MessageUiModel,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterEnd
    ) {
        Message(message)
    }
}

@Composable
fun InputMessage(
    message: MessageUiModel,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        Message(message)
    }
}

@Composable
fun Message(
    message: MessageUiModel
) {
    Box(
        modifier = Modifier
            .widthIn(min = 200.dp, max = 400.dp)
            .background(Color(0.1f, 0.1f, 0.1f))
            .padding(4.dp)
    ) {
        Text(text = message.text)
    }
}