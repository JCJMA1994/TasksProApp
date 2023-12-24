package com.systemfailed.taskspro.navigation

sealed class AppScreens(val route: String) {
    data object SplashScreen : AppScreens("splash_screen")
    data object LoginScreen : AppScreens("login_screen")
    data object RegisterScreen : AppScreens("register_screen")
    data object TasksScreen : AppScreens("tasks_screen")

}