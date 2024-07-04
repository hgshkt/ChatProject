package com.hgshkt.data.repository.user

import com.hgshkt.data.mapper.toDomain
import com.hgshkt.data.mapper.toRepositoryResponse
import com.hgshkt.data.mapper.toStorage
import com.hgshkt.data.storage.user.interfaces.LocalUserStorage
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.domain.data.repository.UserRepository

class UserRepositoryImpl(
    private val remoteUserStorage: RemoteUserStorage,
    private val localUserStorage: LocalUserStorage
) : UserRepository {

    override suspend fun getUserById(id: String): UserRepository.GetUserByIdResponse {
        // if user saved locally,return it
        val localUser = localUserStorage.getUserById(id)
        localUser?.let {
            return UserRepository.GetUserByIdResponse.Success(it.toDomain())
        }
        // in other case fetch value from remote storage
        val response = remoteUserStorage.getUserById(id).toRepositoryResponse()
        // save it locally if not null
        response.value?.let {
            localUserStorage.saveUser(it.toStorage())
        }
        return response
    }

    override fun getCurrentUserId(): String {
        return localUserStorage.getCurrentUserId()
    }
}