package com.hgshkt.chatproject.di

import com.hgshkt.data.remote.api.retrofit.RetrofitClient
import com.hgshkt.data.remote.api.user.UserApi
import com.hgshkt.data.remote.websocket.connect.WebSocketConnector
import com.hgshkt.data.remote.websocket.handle.WebSocketHandlerImpl
import com.hgshkt.data.repository.user.UserRepositoryImpl
import com.hgshkt.data.storage.user.impl.RemoteUserStorageImpl
import com.hgshkt.data.storage.user.interfaces.LocalUserStorage
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.domain.data.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Binds
    @Singleton
    abstract fun provideRemoteUserStorage(
        userRemoteStorageImpl: UserRepositoryImpl
    ): RemoteUserStorage
}

@Module
@InstallIn(SingletonComponent::class)
object DataModuleImpl {

    @Provides
    @Singleton
    fun provideUserRepositoryImpl(
        remoteUserStorage: RemoteUserStorage,
        localUserStorage: LocalUserStorage
    ): UserRepositoryImpl {
        return UserRepositoryImpl(remoteUserStorage, localUserStorage)
    }

    @Provides
    @Singleton
    fun provideRemoteUserStorageImpl(
        api: UserApi
    ): RemoteUserStorageImpl {
        return RemoteUserStorageImpl(api)
    }

    @Provides
    @Singleton
    fun provideUserApi(): UserApi {
        return RetrofitClient.retrofit.create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWebSocketHandlerImpl(
        connector: WebSocketConnector
    ): WebSocketHandlerImpl {
        return WebSocketHandlerImpl(connector)
    }

    @Provides
    @Singleton
    fun provideWebSocketConnector(
        client: OkHttpClient
    ): WebSocketConnector {
        return WebSocketConnector(client)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient()
}