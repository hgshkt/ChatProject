package com.hgshkt.chatproject.presentation.screens.main.friends

import com.hgshkt.domain.usecases.friends.FilterFriendsByQueryUseCase
import com.hgshkt.domain.usecases.friends.GetRecommendedUsersUseCase
import com.hgshkt.domain.usecases.friends.GetUserFriendsUseCase
import com.hgshkt.domain.usecases.friends.SearchUsersByQueryUseCase
import com.hgshkt.domain.usecases.friends.SendFriendInviteUseCase

data class FriendsScreenUseCases(
    val getFriends: GetUserFriendsUseCase,
    val getRecommended: GetRecommendedUsersUseCase,
    val filterFriendsByQuery: FilterFriendsByQueryUseCase,
    val searchUsersByQuery: SearchUsersByQueryUseCase,
    val sendInvite: SendFriendInviteUseCase
)
