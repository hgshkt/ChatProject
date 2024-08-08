package com.hgshkt.chatproject.di.domain

import com.hgshkt.domain.data.repository.ChatRepository
import com.hgshkt.domain.data.repository.MessageRepository
import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.usecases.chatScreen.GetChatDetailUseCase
import com.hgshkt.domain.usecases.chatScreen.SendMessageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object  ChatScreenUseCaseModule {
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