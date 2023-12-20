package com.systemfailed.taskspro.presentation.navigation

sealed class AppScreens(val route: String) {
    data object SplashScreen : AppScreens("splash_screen")
    data object LoginScreen : AppScreens("login_screen")
}