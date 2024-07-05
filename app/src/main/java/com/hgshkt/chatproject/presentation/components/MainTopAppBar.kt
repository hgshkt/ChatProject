package com.hgshkt.chatproject.presentation.components

import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MainTopAppBar(

) {
    val navBarState = rememberDrawerState(DrawerValue.Closed)

    TopAppBar(
        title = { Title() },
        navigationIcon = {
            NavigationIcon {
                navBarState.change()
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
private fun Title(modifier: Modifier = Modifier) {
    Text("Chat Project")
}

@Preview
@Composable
private fun MainTopAppBarPreview() {
    MainTopAppBar()
}