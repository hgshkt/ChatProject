package com.hgshkt.domain.usecases.currentProfile

import com.hgshkt.domain.data.Resultc
import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.model.User

class GetCurrentUserUseCase(
    private val repository: UserRepository
) {
    suspend fun execute(): Resultc<User> {
        val currentUserId = repository.getCurrentUserId()
        return repository.getUserById(currentUserId)
    }
}