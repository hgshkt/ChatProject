package com.hgshkt.data.remote.security

import com.hgshkt.data.remote.api.user.UserApi
import com.hgshkt.data.remote.api.user.request.RegistrationRequest
import com.hgshkt.domain.security.RegistrationService
import com.hgshkt.domain.security.RegistrationService.*

class RegistrationServiceImpl(
    private val api: UserApi
): RegistrationService {
    override suspend fun createUser(registrationData: RegistrationData) {
        val request = registrationData.toRegistrationRequest()
        api.register(request)
    }

    private fun RegistrationData.toRegistrationRequest(): RegistrationRequest {
        return RegistrationRequest(name, login, password)
    }
}
