package com.hgshkt.data.remote.security

import com.hgshkt.data.remote.api.user.UserApi
import com.hgshkt.data.remote.api.user.reponse.ApiRegistrationResponse
import com.hgshkt.data.remote.api.user.request.ApiRegistrationRequest
import com.hgshkt.domain.security.RegistrationService.*
import com.hgshkt.domain.security.RegistrationService

class RegistrationServiceImpl(
    private val api: UserApi
): RegistrationService {
    override suspend fun createUser(
        registrationData: RegistrationData
    ): RegistrationResponse {
        val request = registrationData.toApi()
        return api.register(request).toDomain()
    }

    private fun RegistrationData.toApi(): ApiRegistrationRequest {
        return ApiRegistrationRequest(name, login, password)
    }

    private fun ApiRegistrationResponse.toDomain(): RegistrationResponse {
        return RegistrationResponse(
            success = success,
            message = message,
            createdUserId = userId
        )
    }
}
