package com.hgshkt.domain.usecases.currentProfile

import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.data.repository.UserRepository.LoadUserState
import kotlinx.coroutines.flow.Flow

class FlowCurrentUserUseCase(
    private val repository: UserRepository
) {
    fun execute(): Flow<LoadUserState> {
        return repository.getCurrentUser()
    }
}