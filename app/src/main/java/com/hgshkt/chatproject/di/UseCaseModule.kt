package com.hgshkt.chatproject.di

import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.data.websocket.WebSocketHandler
import com.hgshkt.domain.security.LoginService
import com.hgshkt.domain.security.RegistrationService
import com.hgshkt.domain.usecases.ConnectWebSocketUseCase
import com.hgshkt.domain.usecases.GetUserByIdUseCase
import com.hgshkt.domain.usecases.LoginUseCase
import com.hgshkt.domain.usecases.RegistrationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideConnectWebSocketUseCase(
        handler: WebSocketHandler
    ): ConnectWebSocketUseCase {
        return ConnectWebSocketUseCase(handler)
    }

    @Provides
    @Singleton
    fun provideConnectWebSocketUseCase(
        userRepository: UserRepository
    ): GetUserByIdUseCase {
        return GetUserByIdUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideConnectWebSocketUseCase(
        loginService: LoginService
    ): LoginUseCase {
        return LoginUseCase(loginService)
    }

    @Provides
    @Singleton
    fun provideConnectWebSocketUseCase(
        registrationService: RegistrationService
    ): RegistrationUseCase {
        return RegistrationUseCase(registrationService)
    }
}