package com.hgshkt.chatproject.di.data

import com.hgshkt.data.local.chat.ChatDao
import com.hgshkt.data.local.message.MessageDao
import com.hgshkt.data.local.user.UserDao
import com.hgshkt.data.remote.api.chat.ChatApi
import com.hgshkt.data.remote.api.message.MessageApi
import com.hgshkt.data.remote.api.user.UserApi
import com.hgshkt.data.storage.chat.impl.LocalChatStorageImpl
import com.hgshkt.data.storage.chat.impl.RemoteChatStorageImpl
import com.hgshkt.data.storage.chat.interfaces.LocalChatStorage
import com.hgshkt.data.storage.chat.interfaces.RemoteChatStorage
import com.hgshkt.data.storage.message.impl.LocalMessageStorageImpl
import com.hgshkt.data.storage.message.impl.RemoteMessageStorageImpl
import com.hgshkt.data.storage.message.interfaces.LocalMessageStorage
import com.hgshkt.data.storage.message.interfaces.RemoteMessageStorage
import com.hgshkt.data.storage.user.impl.LocalUserStorageImpl
import com.hgshkt.data.storage.user.impl.RemoteUserStorageImpl
import com.hgshkt.data.storage.user.interfaces.LocalUserStorage
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {
    @Binds
    @Singleton
    abstract fun provideRemoteUserStorage(
        remoteUserStorageImpl: RemoteUserStorageImpl
    ): RemoteUserStorage

    @Binds
    @Singleton
    abstract fun provideLocalUserStorage(
        localUserStorageImpl: LocalUserStorageImpl
    ): LocalUserStorage

    @Binds
    @Singleton
    abstract fun provideRemoteChatStorage(
        remoteChatStorageImpl: RemoteChatStorageImpl
    ): RemoteChatStorage

    @Binds
    @Singleton
    abstract fun provideLocalChatStorage(
        localChatStorageImpl: LocalChatStorageImpl
    ): LocalChatStorage

    @Binds
    @Singleton
    abstract fun provideRemoteMessageStorage(
        remoteMessageStorageImpl: RemoteMessageStorageImpl
    ): RemoteMessageStorage

    @Binds
    @Singleton
    abstract fun provideLocalMessageStorage(
        localMessageStorageImpl: LocalMessageStorageImpl
    ): LocalMessageStorage
}

@Module
@InstallIn(SingletonComponent::class)
object StorageImplModule {
    @Provides
    @Singleton
    fun provideRemoteUserStorageImpl(
        api: UserApi
    ): RemoteUserStorageImpl {
        return RemoteUserStorageImpl(api)
    }

    @Provides
    @Singleton
    fun provideLocalUserStorageImpl(
        userDao: UserDao
    ): LocalUserStorageImpl {
        return LocalUserStorageImpl(userDao)
    }

    @Provides
    @Singleton
    fun provideRemoteChatStorageImpl(
        api: ChatApi
    ): RemoteChatStorageImpl {
        return RemoteChatStorageImpl(api)
    }

    @Provides
    @Singleton
    fun provideLocalChatStorageImpl(
        dao: ChatDao
    ): LocalChatStorageImpl {
        return LocalChatStorageImpl(dao)
    }

    @Provides
    @Singleton
    fun provideRemoteMessageStorageImpl(
        api: MessageApi
    ): RemoteMessageStorageImpl {
        return RemoteMessageStorageImpl(api)
    }

    @Provides
    @Singleton
    fun provideLocalMessageStorageImpl(
        dao: MessageDao
    ): LocalMessageStorageImpl {
        return LocalMessageStorageImpl(dao)
    }
}