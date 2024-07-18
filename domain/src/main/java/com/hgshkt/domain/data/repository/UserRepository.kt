package com.hgshkt.domain.data.repository

import com.hgshkt.domain.data.Result
import com.hgshkt.domain.model.User
import com.hgshkt.domain.model.UserSimpleData
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserById(id: String): Result<User>
    fun getCurrentUserId(): String
    fun getCurrentUserFriends(id: String): Flow<UserSimpleData>
    fun getUsersByQuery(query: String): Flow<UserSimpleData>
}