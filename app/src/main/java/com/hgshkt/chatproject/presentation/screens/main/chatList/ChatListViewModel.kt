package com.hgshkt.chatproject.presentation.screens.main.chatList

import androidx.lifecycle.ViewModel
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.usecases.GetUserChatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

@HiltViewModel
class ChatListViewModel @Inject constructor(
    private val getUserChatsUseCase: GetUserChatsUseCase
) : ViewModel() {

    private val _chats = MutableSharedFlow<List<Chat>>()
    val chats = _chats

    suspend fun fetchChats() {
        getUserChatsUseCase.execute().collect { chats ->
            _chats.tryEmit(chats)
        }
    }
}