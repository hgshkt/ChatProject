package com.hgshkt.domain.usecases

import com.hgshkt.domain.data.UserId
import com.hgshkt.domain.data.UserRepository
import com.hgshkt.domain.model.User

class GetUserByIdUseCase(
    private val userRepository: UserRepository
) {
    suspend fun execute(
        id: UserId
    ): GetUserByIdResponse {
        return userRepository.getUserById(id)
    }
}

sealed class GetUserByIdResponse(
    val success: Boolean,
    val message: String,
    val value: User?
) {
    data class Success(val user: User) : GetUserByIdResponse(
        success = true,
        message = "User received",
        value = user
    )

    data class Failure(val msg: String = "Some error occurred") : GetUserByIdResponse(
        success = false,
        message = msg,
        value = null
    )
}