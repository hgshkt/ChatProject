package com.hgshkt.chatproject.di.data

import com.hgshkt.data.remote.api.user.UserApi
import com.hgshkt.data.remote.security.LoginServiceImpl
import com.hgshkt.data.remote.security.RegistrationServiceImpl
import com.hgshkt.data.remote.websocket.WebSocketServiceImpl
import com.hgshkt.domain.data.websocket.WebSocketService
import com.hgshkt.domain.security.LoginService
import com.hgshkt.domain.security.RegistrationService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
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
    abstract fun provideWebSocketService(
        webSocketServiceImpl: WebSocketServiceImpl
    ): WebSocketService
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
    fun provideWebSocketServiceImpl(
        okHttpClient: OkHttpClient
    ): WebSocketServiceImpl {
        return WebSocketServiceImpl(okHttpClient)
    }
}