package com.hgshkt.chatproject.di.domain

import com.hgshkt.domain.data.repository.ChatRepository
import com.hgshkt.domain.usecases.chatList.ObserveUserChatsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ChatListUseCaseModule {
    @Provides
    @Singleton
    fun provideObserveUserChatsUseCase(
        chatRepository: ChatRepository
    ): ObserveUserChatsUseCase {
        return ObserveUserChatsUseCase(chatRepository)
    }
}