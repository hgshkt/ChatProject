package com.hgshkt.chatproject.di.data

import android.content.Context
import android.content.SharedPreferences
import com.hgshkt.data.local.data.AppPrefs
import com.hgshkt.data.local.data.SharedPrefs
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModuleImpl {

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient()

    @Provides
    @Singleton
    fun provideSharedPrefsImpl(
        sharedPreferences: SharedPreferences
    ): AppPrefs {
        return AppPrefs(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences {
        val name = "app_shared_prefs"
        return context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideSharedPrefs(
        impl: AppPrefs
    ): SharedPrefs
}

