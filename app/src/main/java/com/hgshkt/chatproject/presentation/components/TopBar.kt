package com.hgshkt.chatproject.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val title = "Chat Application"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    drawerState: DrawerState
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = { Title() },
        navigationIcon = {
            NavigationIcon {
                drawerState.change()
            }
        }
    )
}

private fun DrawerState.change() {
    CoroutineScope(Dispatchers.Main).launch {
        if (isOpen) close()
        else open()
    }
}

@Composable
private fun NavigationIcon(
    onIconClick: () -> Unit
) {
    IconButton(onClick = { onIconClick() }) {
        Icon(
            imageVector = Icons.Filled.Menu,
            contentDescription = "Navigation menu icon"
        )
    }
}

@Composable
private fun Title() {
    Text(title)
}