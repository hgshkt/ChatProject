package com.hgshkt.chatproject.di.data

import com.hgshkt.data.filter.user.UserFilter
import com.hgshkt.data.repository.chat.ChatRepositoryImpl
import com.hgshkt.data.repository.message.MessageRepositoryImpl
import com.hgshkt.data.repository.user.UserRepositoryImpl
import com.hgshkt.data.storage.chat.interfaces.LocalChatStorage
import com.hgshkt.data.storage.chat.interfaces.RemoteChatStorage
import com.hgshkt.data.storage.data.interfaces.LocalDataStorage
import com.hgshkt.data.storage.message.interfaces.LocalMessageStorage
import com.hgshkt.data.storage.message.interfaces.RemoteMessageStorage
import com.hgshkt.data.storage.user.interfaces.LocalUserStorage
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.domain.data.repository.ChatRepository
import com.hgshkt.domain.data.repository.MessageRepository
import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.data.websocket.WebSocketService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryInterfaceModule {
    @Binds
    @Singleton
    abstract fun provideUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Binds
    @Singleton
    abstract fun provideChatRepository(
        chatRepositoryImpl: ChatRepositoryImpl
    ): ChatRepository

    @Binds
    @Singleton
    abstract fun provideMessageRepository(
        messageRepositoryImpl: MessageRepositoryImpl
    ): MessageRepository
}
@Module
@InstallIn(SingletonComponent::class)
object RepositoryImplModule {
    @Provides
    @Singleton
    fun provideUserRepositoryImpl(
        remoteUserStorage: RemoteUserStorage,
        localUserStorage: LocalUserStorage,
        userFilter: UserFilter,
        @Named(CURRENT_USER_ID) currentUserId: String
    ): UserRepositoryImpl {
        return UserRepositoryImpl(
            remoteUserStorage = remoteUserStorage,
            localUserStorage = localUserStorage,
            userFilter = userFilter,
            currentUserId = currentUserId
        )
    }

    @Provides
    @Singleton
    fun provideChatRepositoryImpl(
        remoteChatStorage: RemoteChatStorage,
        localChatStorage: LocalChatStorage,
        localDataStorage: LocalDataStorage,
        webSocketService: WebSocketService
    ): ChatRepositoryImpl {
        return ChatRepositoryImpl(
            remoteChatStorage = remoteChatStorage,
            localChatStorage = localChatStorage,
            localDataStorage = localDataStorage,
            webSocketService = webSocketService
        )
    }

    @Provides
    @Singleton
    fun provideMessageRepositoryImpl(
        localMessageStorage: LocalMessageStorage,
        remoteMessageStorage: RemoteMessageStorage,
        webSocketService: WebSocketService
    ): MessageRepositoryImpl {
        return MessageRepositoryImpl(
            localMessageStorage = localMessageStorage,
            remoteMessageStorage = remoteMessageStorage,
            webSocketService = webSocketService
        )
    }
}