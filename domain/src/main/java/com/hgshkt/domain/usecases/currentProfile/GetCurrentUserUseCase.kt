package com.hgshkt.domain.usecases.currentProfile

import com.hgshkt.domain.data.repository.UserRepository

class GetCurrentUserUseCase(
    private val repository: UserRepository
) {
    suspend fun execute(): UserRepository.UserResponse {
        val currentUserId = repository.getCurrentUserId()
        return repository.getUserById(currentUserId)
    }
}