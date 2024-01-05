package com.systemfailed.taskspro.features.auth.data

sealed class AuthenticationEvent {
    data object ToggleAuthenticationMode : AuthenticationEvent()

    class EmailChanged(val emailAddress: String) : AuthenticationEvent()

    class PasswordChanged(val password: String) : AuthenticationEvent()

    data object Authenticate : AuthenticationEvent()

    data object ErrorDismissed : AuthenticationEvent()
}