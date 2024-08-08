package com.hgshkt.chatproject.presentation.screens.main.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val getChatDetailUseCase: GetChatDetailUseCase,
    private val sendMessageUseCase: SendMessageUseCase
) : ViewModel() {

    private val _chat = MutableStateFlow<Chat?>(null)
    val chat: Flow<Chat?>
        get() = _chat

    private val _messages = MutableStateFlow<List<Message>>(mutableListOf())
    val messages: Flow<List<Message>>
        get() = _messages

    fun fetchChat(id: String) {
        viewModelScope.launch {
            val detail = getChatDetailUseCase.execute(id)
            detail.chatFlow.collect { chat ->
                handleChat(chat)
            }
            detail.messagesFlow.collect { messages->
                handleMessages(messages)
            }
        }
    }

    private fun handleChat(chat: Chat) {
        _chat.value = chat
    }

    private fun handleMessages(messages: List<Message>) {
        _messages.value = messages
    }

    fun sendMessage(text: String) {
        viewModelScope.launch {
            sendMessageUseCase.execute(_chat.value!!.id, text)
        }
    }
}