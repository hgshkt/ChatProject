package com.hgshkt.domain.usecases.friends

import com.hgshkt.domain.data.repository.UserRepository

class DeleteFriendUseCase(
    private val userRepository: UserRepository
) {
    suspend fun execute(id: String) {
        userRepository.deleteFriend(id)
    }
}