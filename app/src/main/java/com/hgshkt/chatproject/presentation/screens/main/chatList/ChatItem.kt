package com.hgshkt.chatproject.presentation.screens.main.chatList

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import com.hgshkt.chatproject.presentation.model.UiChat

@Composable
fun ChatItem(
    chat: UiChat
) {
    Row(
        modifier = Modifier.padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ChatAvatar(bitmap = chat.avatar)
        Column {
            ChatName(chat.name)
        }
    }
}

@Composable
fun ChatAvatar(
    bitmap: Bitmap?,
    modifier: Modifier = Modifier
) {
    Image(
        bitmap = bitmap?.asImageBitmap()!!, // ?: default image
        contentDescription = "Chat avatar",
        modifier = modifier
    )
}

@Composable
fun ChatName(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(name, modifier)
}