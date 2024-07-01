package com.hgshkt.chatproject.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hgshkt.chatproject.R

@Composable
fun UserAvatar(
    modifier: Modifier = Modifier,
    url: String?
) {
    AsyncImage(
        model = url,
        contentDescription = "User avatar",
        modifier = modifier,
        error = painterResource(R.drawable.avatar_error),
        placeholder = painterResource(R.drawable.loading_avatar),
        fallback = painterResource(R.drawable.default_user_avatar)
    )
}

@Composable
fun ProfileBackground(
    modifier: Modifier = Modifier,
    url: String
) {
    AsyncImage(
        model = url,
        contentDescription = "Profile background",
        modifier = modifier,
        error = painterResource(R.drawable.backgrounf_error),
        placeholder = painterResource(R.drawable.loading_background_avatar),
        fallback = painterResource(R.drawable.default_background)
    )
}

@Composable
fun ProfileUserName(
    modifier: Modifier = Modifier,
    name: String
) {
    Box(modifier = modifier)
    Text(text = name)
}