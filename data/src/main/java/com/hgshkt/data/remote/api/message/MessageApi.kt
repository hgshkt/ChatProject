package com.hgshkt.data.remote.api.message

import com.hgshkt.data.remote.api.message.model.ApiMessageResponse
import retrofit2.http.GET
import retrofit2.http.POST


interface MessageApi {
    @GET("")
    suspend fun getMessagesByChatId(chatId: String): ApiMessageResponse

    @POST("")
    fun sendMessage(chatId: String, text: String, senderId: String)
}