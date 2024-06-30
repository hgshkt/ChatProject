package com.hgshkt.domain.usecases

import com.hgshkt.domain.data.repository.UserRepository

class GetCurrentUserUseCase(
    private val repository: UserRepository
) {
    suspend fun execute(): UserRepository.GetUserByIdResponse {
        val currentUserId = repository.getCurrentUserId()
        return repository.getUserById(currentUserId)
    }
}