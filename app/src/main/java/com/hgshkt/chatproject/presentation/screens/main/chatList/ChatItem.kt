package com.hgshkt.chatproject.presentation.screens.main.chatList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hgshkt.chatproject.R
import com.hgshkt.chatproject.presentation.data.model.UiChat

@Composable
fun ChatItem(
    chat: UiChat
) {
    Row(
        modifier = Modifier.padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ChatAvatar(avatarUrl = chat.avatarUrl)
        Column {
            ChatName(chat.name)
        }
    }
}

@Composable
fun ChatAvatar(
    avatarUrl: String?,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = avatarUrl,
        contentDescription = "Chat avatar",
        modifier = modifier,
        error = painterResource(R.drawable.avatar_error),
        placeholder = painterResource(R.drawable.loading_avatar),
        fallback = painterResource(R.drawable.default_chat_avatar)
    )
}

@Composable
fun ChatName(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(name, modifier)
}