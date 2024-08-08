package com.hgshkt.chatproject.di.domain

import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.usecases.friends.DeleteFriendUseCase
import com.hgshkt.domain.usecases.friends.FilterFriendsByQueryUseCase
import com.hgshkt.domain.usecases.friends.GetRecommendedUsersUseCase
import com.hgshkt.domain.usecases.friends.GetUserFriendsUseCase
import com.hgshkt.domain.usecases.friends.SearchUsersByQueryUseCase
import com.hgshkt.domain.usecases.friends.SendFriendInviteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FriendsUseCaseModule {
    @Provides
    @Singleton
    fun provideDeleteFriendUseCase(userRepository: UserRepository): DeleteFriendUseCase {
        return DeleteFriendUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideFilterFriendsByQueryUseCase(userRepository: UserRepository): FilterFriendsByQueryUseCase {
        return FilterFriendsByQueryUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideGetRecommendedUsersUseCase(userRepository: UserRepository): GetRecommendedUsersUseCase {
        return GetRecommendedUsersUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideGetUserFriendsUseCase(userRepository: UserRepository): GetUserFriendsUseCase {
        return GetUserFriendsUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideSearchUsersByQueryUseCase(userRepository: UserRepository): SearchUsersByQueryUseCase {
        return SearchUsersByQueryUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideSendFriendInviteUseCase(userRepository: UserRepository): SendFriendInviteUseCase {
        return SendFriendInviteUseCase(userRepository)
    }
}