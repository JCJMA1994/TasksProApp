package com.systemfailed.taskspro.features.auth.domain.usecases

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.systemfailed.taskspro.features.auth.data.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    operator fun invoke(email: String, password: String): Task<AuthResult> {
        return loginRepository.doLogin(email, password)
    }
}