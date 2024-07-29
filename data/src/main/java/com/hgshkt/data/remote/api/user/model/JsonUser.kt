package com.hgshkt.data.remote.api.user.model

/**
 * Detail user data
 */
data class JsonUser(
    val id: String,
    val name: String,
    val avatarUrl: String?,
    val backgroundUrl: String?
)
