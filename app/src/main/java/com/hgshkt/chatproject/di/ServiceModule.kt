package com.hgshkt.chatproject.di

import com.hgshkt.chatproject.presentation.data.WebSocketManagerImpl
import com.hgshkt.data.remote.api.user.UserApi
import com.hgshkt.data.remote.security.LoginServiceImpl
import com.hgshkt.data.remote.security.RegistrationServiceImpl
import com.hgshkt.data.remote.websocket.connect.WebSocketConnector
import com.hgshkt.data.remote.websocket.handle.WebSocketHandlerImpl
import com.hgshkt.domain.data.websocket.WebSocketHandler
import com.hgshkt.domain.data.websocket.WebSocketManager
import com.hgshkt.domain.security.LoginService
import com.hgshkt.domain.security.RegistrationService
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    abstract fun provideLoginService(
        loginServiceImpl: LoginServiceImpl
    ): LoginService

    abstract fun provideRegistrationService(
        registrationServiceImpl: RegistrationServiceImpl
    ): RegistrationService

    abstract fun provideWebSocketManager(
        webSocketManagerImpl: WebSocketManagerImpl
    ): WebSocketManager
}

@Module
@InstallIn(SingletonComponent::class)
object ServiceImplModule {
    fun provideLoginServiceImpl(
        api: UserApi
    ): LoginServiceImpl {
        return LoginServiceImpl(api)
    }

    fun provideRegistrationServiceImpl(
        api: UserApi
    ): RegistrationServiceImpl {
        return RegistrationServiceImpl(api)
    }

    fun provideWebSocketManagerImpl(
        webSocketHandler: WebSocketHandler
    ): WebSocketManagerImpl {
        return WebSocketManagerImpl(webSocketHandler)
    }
}