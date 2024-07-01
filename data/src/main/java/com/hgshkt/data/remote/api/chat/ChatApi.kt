package com.hgshkt.data.remote.api.chat

import com.hgshkt.data.remote.api.chat.model.ApiChatResponse
import retrofit2.http.GET

interface ChatApi {
    @GET("")
    suspend fun getChatById(id: String): ApiChatResponse
}