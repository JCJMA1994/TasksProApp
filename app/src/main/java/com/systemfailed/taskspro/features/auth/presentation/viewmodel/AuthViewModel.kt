package com.systemfailed.taskspro.features.auth.presentation.viewmodel

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.systemfailed.taskspro.features.auth.data.AuthenticationEvent
import com.systemfailed.taskspro.features.auth.data.AuthenticationMode
import com.systemfailed.taskspro.features.auth.data.AuthenticationState
import com.systemfailed.taskspro.features.auth.data.PasswordRequirement
import com.systemfailed.taskspro.features.auth.domain.usecases.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
) : ViewModel() {

    private val uiState = MutableStateFlow(AuthenticationState())

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _lastname = MutableLiveData<String>()
    val lastname: LiveData<String> = _lastname

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _isRegisterEnable = MutableLiveData<Boolean>()
    val isRegisterEnable: LiveData<Boolean> = _isRegisterEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _loginAlert = MutableLiveData<Boolean>()
    val loginAlert: LiveData<Boolean> = _loginAlert

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password

        _isLoginEnable.value = enableLogin(email, password)

    }

    fun onRegisterChanged(
        username: String,
        name: String,
        lastname: String,
        email: String,
        password: String
    ) {
        _username.value = username
        _name.value = name
        _lastname.value = lastname
        _email.value = email
        _password.value = password

        _isRegisterEnable.value = enableLogin(email, password)

    }

    private fun enableLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6


    fun onLoginSelected(onSuccess: () -> Unit) {
        try {
            viewModelScope.launch {
                _isLoading.value = true
                authUseCase(email.value!!, password.value!!).addOnCompleteListener { result ->
                    if (result.isSuccessful) {
                        Log.i("Joao", "Inicio de sesion correcto")
                        onSuccess()
                    } else {
                        _loginAlert.value = true
                    }
                }

                _isLoading.value = false
            }
        } catch (e: Exception) {
            Log.d("Error", "Error: ${e.localizedMessage}")
        }
    }

    fun onRegisterSelected(onSuccess: () -> Unit) {
        try {
            viewModelScope.launch {
                authUseCase.doRegister(email.value!!, password.value!!)
                    .addOnCompleteListener { result ->
                        if (result.isSuccessful) {
                            authUseCase.saveRegister(
                                username.value!!,
                                name.value!!,
                                lastname.value!!
                            ).addOnCompleteListener {
                                if (result.isSuccessful) {
                                    Log.i("Joao", "Inicio de sesion correcto")
                                    onSuccess()
                                } else {
                                    _loginAlert.value = true
                                }
                            }
                            Log.i("Joao", "Inicio de sesion correcto")
                            onSuccess()
                        } else {
                            _loginAlert.value = true
                        }
                    }

            }
        } catch (e: Exception) {
            Log.d("Error", "Error: ${e.localizedMessage}")
        }
    }


    fun closureAlert() {
        _loginAlert.value = false
    }

    fun handleEvent(authenticationEvent: AuthenticationEvent) {
        when (authenticationEvent) {
            AuthenticationEvent.ToggleAuthenticationMode -> toggleAuthenticationMode()
            is AuthenticationEvent.EmailChanged -> {
                updateEmail(authenticationEvent.emailAddress)
            }

            is AuthenticationEvent.PasswordChanged -> {
                updatePassword(authenticationEvent.password)
            }

            AuthenticationEvent.Authenticate -> authenticate()
            AuthenticationEvent.ErrorDismissed -> dismissError()
        }
    }

    private fun authenticate() {
        uiState.value = uiState.value.copy(isLoading = true)
        // trigger network request

        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)
            withContext(Dispatchers.Main) {
                uiState.value = uiState.value.copy(
                    isLoading = false,
                    error = "Something went wrong!"
                )
            }
        }
    }

    private fun dismissError() {
        uiState.value = uiState.value.copy(error = null)
    }

    private fun updateEmail(email: String) {
        uiState.value = uiState.value.copy(email = email)
    }

    private fun updatePassword(password: String) {
        val satisfiedRequirements = mutableListOf<PasswordRequirement>()
        if (password.length > 7) {
            satisfiedRequirements.add(PasswordRequirement.EIGHT_CHARACTERS)
        }
        if (password.any { it.isDigit() }) {
            satisfiedRequirements.add(PasswordRequirement.NUMBER)
        }
        if (password.any { it.isUpperCase() }) {
            satisfiedRequirements.add(PasswordRequirement.CAPITAL_LETTER)
        }

        uiState.value = uiState.value.copy(
            password = password,
            satisfiedPasswordRequirements = satisfiedRequirements.toList()
        )
    }

    private fun toggleAuthenticationMode() {
        val currentMode = uiState.value.authenticationMode
        val newMode = if (currentMode == AuthenticationMode.SIGN_IN) {
            AuthenticationMode.SIGN_UP
        } else AuthenticationMode.SIGN_IN

        uiState.value = uiState.value.copy(authenticationMode = newMode)
    }
}