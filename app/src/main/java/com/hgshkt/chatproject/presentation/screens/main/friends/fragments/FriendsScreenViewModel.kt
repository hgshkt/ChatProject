package com.hgshkt.chatproject.presentation.screens.main.friends.fragments

import androidx.lifecycle.ViewModel
import com.hgshkt.domain.usecases.friends.GetUserFriendsUseCase
import com.hgshkt.domain.usecases.friends.SearchUsersByQueryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FriendsScreenViewModel @Inject constructor(
    private val getUserFriendsUseCase: GetUserFriendsUseCase,
    private val searchUsersByStringUseCase: SearchUsersByQueryUseCase
): ViewModel() {



}