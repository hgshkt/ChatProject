package com.hgshkt.chatproject.presentation.screens.main.friends

data class FriendsScreenUseCases(
    val getFriends: GetUserFriendsUseCase,
    val getRecommended: GetRecommendedUsersUseCase,
    val filterFriendsByQuery: FilterFriendsByQueryUseCase,
    val searchUsersByQuery: SearchUsersByQueryUseCase,
    val sendInvite: SendFriendInviteUseCase,
    val delete: DeleteFriendUseCase
)
