package com.hgshkt.domain.usecases.friends

import com.hgshkt.domain.data.repository.UserRepository

class SendFriendRequestUseCase(
    private val userRepository: UserRepository
) {
    suspend fun execute(id: String) {
        val curId = userRepository.getCurrentUserId()
        userRepository.sendFriendRequest(from = curId, to = id)
    }
}