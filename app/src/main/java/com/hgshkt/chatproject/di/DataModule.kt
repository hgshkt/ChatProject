package com.hgshkt.chatproject.di

import com.hgshkt.data.remote.websocket.connect.WebSocketConnector
import com.hgshkt.data.remote.websocket.handle.WebSocketHandlerImpl
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient

@Module
@InstallIn(SingletonComponent::class)
object DataModuleImpl {
    fun provideWebSocketHandlerImpl(
        connector: WebSocketConnector
    ): WebSocketHandlerImpl {
        return WebSocketHandlerImpl(connector)
    }

    fun provideWebSocketConnector(
        client: OkHttpClient
    ): WebSocketConnector {
        return WebSocketConnector(client)
    }

    fun provideOkHttpClient() = OkHttpClient()
}