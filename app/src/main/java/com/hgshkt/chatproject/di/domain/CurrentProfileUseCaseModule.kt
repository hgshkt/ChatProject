package com.hgshkt.chatproject.di.domain

import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.usecases.currentProfile.FlowCurrentUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CurrentProfileUseCaseModule {
    @Provides
    @Singleton
    fun provideGetCurrentUserUseCase(
        userRepository: UserRepository
    ): FlowCurrentUserUseCase {
        return FlowCurrentUserUseCase(userRepository)
    }
}