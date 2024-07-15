package com.hgshkt.chatproject.di.data

import com.hgshkt.data.remote.api.chat.ChatApi
import com.hgshkt.data.remote.api.message.MessageApi
import com.hgshkt.data.remote.api.retrofit.RetrofitClient
import com.hgshkt.data.remote.api.user.UserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideUserApi(): UserApi {
        return RetrofitClient.retrofit.create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideChatApi(): ChatApi {
        return RetrofitClient.retrofit.create(ChatApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMessageApi(): MessageApi {
        return RetrofitClient.retrofit.create(MessageApi::class.java)
    }
}