package com.systemfailed.taskspro.features.auth.domain.usecases

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.systemfailed.taskspro.features.auth.data.repository.AuthRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(email: String, password: String): Task<AuthResult> {
        return authRepository.doLogin(email, password)
    }

    fun doRegister(email: String, password: String): Task<AuthResult> {
        return authRepository.doRegister(email, password)
    }

    fun saveRegister(userName: String, name: String, lastname: String): Task<Void> {
        return authRepository.saveRegister(userName, name, lastname)
    }

}