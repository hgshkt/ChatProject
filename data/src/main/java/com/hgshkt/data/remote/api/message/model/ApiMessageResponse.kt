package com.hgshkt.data.remote.api.message.model

data class ApiMessageResponse(
    val success: Boolean,
    val responseMessage: String,
    val messages: List<JsonMessage>
)
