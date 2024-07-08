package com.hgshkt.chatproject.presentation.screens.main.chatList

import androidx.lifecycle.ViewModel
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.usecases.chatList.ObserveUserChatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

@HiltViewModel
class ChatListViewModel @Inject constructor(
    private val observeUserChatsUseCase: ObserveUserChatsUseCase
) : ViewModel() {

    private val _chats = MutableSharedFlow<List<Chat>>()
    val chats = _chats

    suspend fun fetchChats() {
        observeUserChatsUseCase.execute().collect { chats ->
            _chats.tryEmit(chats)
        }
    }
}