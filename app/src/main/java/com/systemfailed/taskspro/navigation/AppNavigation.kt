package com.systemfailed.taskspro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.systemfailed.taskspro.features.auth.presentation.ui.LoginScreen
import com.systemfailed.taskspro.features.auth.presentation.ui.RegisterScreen
import com.systemfailed.taskspro.features.splash.NavSplash
import com.systemfailed.taskspro.features.tasks.presentation.ui.Tasks

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route
    ) {
        composable(AppScreens.SplashScreen.route) {
            NavSplash(navController)
        }
        composable(AppScreens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(AppScreens.RegisterScreen.route) {
            RegisterScreen(navController)
        }
        composable(AppScreens.TasksScreen.route) {
            Tasks()
        }
    }
}