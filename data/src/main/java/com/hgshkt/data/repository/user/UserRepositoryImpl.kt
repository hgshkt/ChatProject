package com.hgshkt.data.repository.user

import com.hgshkt.data.mapper.toRepositoryResponse
import com.hgshkt.data.storage.interfaces.LocalUserStorage
import com.hgshkt.data.storage.interfaces.RemoteUserStorage
import com.hgshkt.domain.data.repository.UserRepository

class UserRepositoryImpl(
    private val remoteUserStorage: RemoteUserStorage,
    private val localUserStorage: LocalUserStorage
): UserRepository {

    override suspend fun getUserById(id: String): UserRepository.GetUserByIdResponse {
        return remoteUserStorage.getUserById().toRepositoryResponse()
    }

    override fun getCurrentUserId(): String {
        return localUserStorage.getCurrentUserId()
    }
}