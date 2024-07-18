package com.hgshkt.domain.usecases.currentProfile

import com.hgshkt.domain.data.Result
import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.model.User

class GetCurrentUserUseCase(
    private val repository: UserRepository
) {
    suspend fun execute(): Result<User> {
        val currentUserId = repository.getCurrentUserId()
        return repository.getUserById(currentUserId)
    }
}