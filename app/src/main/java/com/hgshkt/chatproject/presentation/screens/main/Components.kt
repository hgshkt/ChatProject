package com.hgshkt.chatproject.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.hgshkt.chatproject.R
import com.hgshkt.chatproject.presentation.data.model.UiUser

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
    url: String?
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
fun SearchField(
    modifier: Modifier = Modifier,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    onButtonClick: () -> Unit
) {
    Row(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(placeholder)
            }
        )
        IconButton(onClick = onButtonClick) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search button"
            )
        }
    }
}

@Composable
fun UserList(
    modifier: Modifier = Modifier,
    users: List<UiUser>,
    itemContent: @Composable () -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(count = users.size) {
            itemContent()
        }
    }
}

@Composable
fun ProfileUserName(
    modifier: Modifier = Modifier,
    name: String
) {
    Box(modifier = modifier)
    Text(text = name)
}