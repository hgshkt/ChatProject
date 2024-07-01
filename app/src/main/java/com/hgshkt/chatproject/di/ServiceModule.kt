package com.hgshkt.chatproject.di

import com.hgshkt.chatproject.presentation.data.WebSocketManagerImpl
import com.hgshkt.data.remote.api.user.UserApi
import com.hgshkt.data.remote.security.LoginServiceImpl
import com.hgshkt.data.remote.security.RegistrationServiceImpl
import com.hgshkt.domain.data.websocket.WebSocketHandler
import com.hgshkt.domain.data.websocket.WebSocketManager
import com.hgshkt.domain.security.LoginService
import com.hgshkt.domain.security.RegistrationService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Binds
    @Singleton
    abstract fun provideLoginService(
        loginServiceImpl: LoginServiceImpl
    ): LoginService

    @Binds
    @Singleton
    abstract fun provideRegistrationService(
        registrationServiceImpl: RegistrationServiceImpl
    ): RegistrationService

    @Binds
    @Singleton
    abstract fun provideWebSocketManager(
        webSocketManagerImpl: WebSocketManagerImpl
    ): WebSocketManager
}

@Module
@InstallIn(SingletonComponent::class)
object ServiceImplModule {

    @Provides
    @Singleton
    fun provideLoginServiceImpl(
        api: UserApi
    ): LoginServiceImpl {
        return LoginServiceImpl(api)
    }

    @Provides
    @Singleton
    fun provideRegistrationServiceImpl(
        api: UserApi
    ): RegistrationServiceImpl {
        return RegistrationServiceImpl(api)
    }

    @Provides
    @Singleton
    fun provideWebSocketManagerImpl(
        webSocketHandler: WebSocketHandler
    ): WebSocketManagerImpl {
        return WebSocketManagerImpl(webSocketHandler)
    }
}