package com.hgshkt.domain.usecases.friends

import com.hgshkt.domain.data.repository.UserRepository

class SendFriendInviteUseCase(
    private val userRepository: UserRepository
) {
    suspend fun execute(id: String) {
        userRepository.sendFriendInvite(id)
    }
}