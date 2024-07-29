package com.hgshkt.data.remote.api.user.model

/**
 * Simple user data. Used for fast browsing friend list, user list, etc.
 */
data class JsonSimpleUser(
    val id: String,
    val name: String,
    val avatarUrl: String?
)
