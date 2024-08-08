package com.hgshkt.chatproject.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.hgshkt.chatproject.R
import com.hgshkt.chatproject.presentation.data.model.UiUserSimpleData
import com.hgshkt.domain.model.UserSimpleData

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
    url: String? = null
) {
    AsyncImage(
        model = url,
        contentDescription = "Profile background",
        modifier = modifier,
        error = painterResource(R.drawable.background_error),
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
    users: List<UiUserSimpleData>,
    additionalContent: @Composable (user: UiUserSimpleData) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(count = users.size) { index ->
            val user = users[index]
            UserItemBase(user = user) {
                additionalContent(user)
            }
        }
    }
}

@Composable
fun UserItemBase(
    modifier: Modifier = Modifier,
    user: UiUserSimpleData,
    content: @Composable () -> Unit
) {
    Row(modifier = modifier) {
        UserAvatar(url = user.avatarUrl)
        Text(user.name)
        content()
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