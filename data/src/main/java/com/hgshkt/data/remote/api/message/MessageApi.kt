package com.hgshkt.data.remote.api.message

import com.hgshkt.data.remote.api.message.model.ApiMessageResponse
import com.hgshkt.data.remote.api.message.model.JsonMessage
import retrofit2.http.GET
import retrofit2.http.POST


interface MessageApi {
    @GET("")
    suspend fun getMessagesByChatId(chatId: String): List<JsonMessage>

    @POST("")
    fun sendMessage(chatId: String, text: String, senderId: String)
}