package com.hgshkt.domain.usecases.friends

import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.model.User
import kotlinx.coroutines.flow.Flow

class GetUserFriendsUseCase(
    private val userRepository: UserRepository
) {
    suspend fun execute(): UserRepository.UserListResponse {
        val id = userRepository.getCurrentUserId()
        return userRepository.getFriendsFor(id)
    }
}