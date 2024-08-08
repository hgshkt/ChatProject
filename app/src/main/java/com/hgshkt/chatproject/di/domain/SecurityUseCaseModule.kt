package com.hgshkt.chatproject.di.domain

import com.hgshkt.domain.security.LoginService
import com.hgshkt.domain.security.RegistrationService
import com.hgshkt.domain.usecases.secutity.LoginUseCase
import com.hgshkt.domain.usecases.secutity.RegistrationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SecurityUseCaseModule {
    @Provides
    @Singleton
    fun provideLoginUseCase(
        loginService: LoginService
    ): LoginUseCase {
        return LoginUseCase(loginService)
    }

    @Provides
    @Singleton
    fun provideRegistrationUseCase(
        registrationService: RegistrationService
    ): RegistrationUseCase {
        return RegistrationUseCase(registrationService)
    }
}