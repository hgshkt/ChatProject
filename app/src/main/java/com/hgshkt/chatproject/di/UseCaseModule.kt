package com.hgshkt.chatproject.di

import com.hgshkt.domain.data.repository.ChatRepository
import com.hgshkt.domain.data.repository.MessageRepository
import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.security.LoginService
import com.hgshkt.domain.security.RegistrationService
import com.hgshkt.domain.usecases.GetChatDetailUseCase
import com.hgshkt.domain.usecases.GetUserByIdUseCase
import com.hgshkt.domain.usecases.LoginUseCase
import com.hgshkt.domain.usecases.RegistrationUseCase
import com.hgshkt.domain.usecases.SendMessageUseCase
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

    @Provides
    @Singleton
    fun provideGetChatDetailUseCase(
        chatRepository: ChatRepository,
        messageRepository: MessageRepository
    ): GetChatDetailUseCase {
        return GetChatDetailUseCase(chatRepository, messageRepository)
    }

    @Provides
    @Singleton
    fun provideSendMessageUseCase(
        messageRepository: MessageRepository,
        userRepository: UserRepository
    ): SendMessageUseCase {
        return SendMessageUseCase(messageRepository, userRepository)
    }
}