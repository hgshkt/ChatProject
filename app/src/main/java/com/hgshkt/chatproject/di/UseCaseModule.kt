package com.hgshkt.chatproject.di

import com.hgshkt.domain.data.repository.ChatRepository
import com.hgshkt.domain.data.repository.MessageRepository
import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.security.LoginService
import com.hgshkt.domain.security.RegistrationService
import com.hgshkt.domain.usecases.chatScreen.GetChatDetailUseCase
import com.hgshkt.domain.usecases.GetUserByIdUseCase
import com.hgshkt.domain.usecases.chatList.ObserveUserChatsUseCase
import com.hgshkt.domain.usecases.secutity.LoginUseCase
import com.hgshkt.domain.usecases.secutity.RegistrationUseCase
import com.hgshkt.domain.usecases.chatScreen.SendMessageUseCase
import com.hgshkt.domain.usecases.currentProfile.FlowCurrentUserUseCase
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
    fun provideGetUserByIdUseCase(
        userRepository: UserRepository
    ): GetUserByIdUseCase {
        return GetUserByIdUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideLoginUseCase(
        loginService: LoginService
    ): LoginUseCase {
        return LoginUseCase(loginService)
    }

    @Provides
    @Singleton
    fun provideRegistrationUseCase(
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

    @Provides
    @Singleton
    fun provideGetCurrentUserUseCase(
        userRepository: UserRepository
    ): FlowCurrentUserUseCase {
        return FlowCurrentUserUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideObserveUserChatsUseCase(
        chatRepository: ChatRepository
    ): ObserveUserChatsUseCase {
        return ObserveUserChatsUseCase(chatRepository)
    }
}