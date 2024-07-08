package com.hgshkt.chatproject.di.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModuleImpl {

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient()
}