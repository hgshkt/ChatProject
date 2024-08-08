package com.hgshkt.domain.data.repository

import com.hgshkt.domain.model.User
import com.hgshkt.domain.data.Resultc
import com.hgshkt.domain.model.UserSimpleData
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserById(id: String): Flow<LoadUserState>
    fun getCurrentUser(): Flow<LoadUserState>
    suspend fun getRecommended(): Resultc<List<UserSimpleData>>
    suspend fun getFriends(): Resultc<List<UserSimpleData>>
    suspend fun getUsersByQuery(query: String): Resultc<List<UserSimpleData>>
    fun filterFriendsByQuery(query: String): List<UserSimpleData>
    suspend fun sendFriendInvite(id: String)
    suspend fun deleteFriend(id: String)

    sealed class LoadUserState {
        data class LocalSuccess(val simpleData: UserSimpleData): LoadUserState()
        data class LocalError(val message: String): LoadUserState()
        data class RemoteSuccess(val user: User): LoadUserState()
        data class RemoteError(val message: String): LoadUserState()
    }
}