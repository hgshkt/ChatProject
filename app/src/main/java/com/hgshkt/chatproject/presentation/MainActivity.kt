package com.hgshkt.chatproject.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.hgshkt.chatproject.presentation.components.TopBar
import com.hgshkt.chatproject.presentation.navigation.AppDrawer
import com.hgshkt.chatproject.presentation.navigation.MainNavGraph
import com.hgshkt.chatproject.presentation.ui.theme.ChatProjectTheme
import com.hgshkt.domain.data.websocket.WebSocketService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity(
    private val webSocketService: WebSocketService
) : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webSocketService.open()
        setContent {
            ChatProjectTheme {
                val controller = rememberNavController()
                val drawerState = rememberDrawerState(DrawerValue.Closed)

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppDrawer(drawerState) {
                        Scaffold(
                            topBar = { TopBar(drawerState) }
                        ) {
                            MainNavGraph(controller = controller)
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        webSocketService.close()
    }
}