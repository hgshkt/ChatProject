package com.hgshkt.chatproject.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.hgshkt.chatproject.presentation.navigation.NavGraph
import com.hgshkt.chatproject.presentation.ui.theme.ChatProjectTheme
import com.hgshkt.domain.data.websocket.WebSocketManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity(
    private val webSocketManager: WebSocketManager
) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavGraph()
                }
            }
        }
        webSocketManager.open()
    }
}