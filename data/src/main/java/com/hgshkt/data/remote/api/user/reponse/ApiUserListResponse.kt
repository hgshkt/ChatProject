package com.hgshkt.data.remote.api.user.reponse

import com.hgshkt.data.remote.api.user.model.JsonSimpleUser

/**
 * List of simple user data
 */
data class ApiUserListResponse(
    val success: Boolean,
    val message: String,
    val jsonUsers: List<JsonSimpleUser>?
)
