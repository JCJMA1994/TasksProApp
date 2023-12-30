package com.systemfailed.taskspro.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.systemfailed.taskspro.features.auth.presentation.ui.LoginScreen
import com.systemfailed.taskspro.features.auth.presentation.ui.RegisterScreen
import com.systemfailed.taskspro.features.auth.presentation.viewmodel.LoginViewModel
import com.systemfailed.taskspro.features.onboarding.presentation.MainOnBoarding
import com.systemfailed.taskspro.features.onboarding.presentation.viewmodel.DataStoreViewModel
import com.systemfailed.taskspro.features.splash.NavSplash
import com.systemfailed.taskspro.features.tasks.presentation.ui.Tasks

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val loginViewModel: LoginViewModel = viewModel()
    val dataStoreViewModel: DataStoreViewModel = viewModel()

    val store = dataStoreViewModel.getBoarding.collectAsState(initial = false)

    NavHost(
        navController = navController,
        startDestination = if (store.value) AppScreens.LoginScreen.route else AppScreens.SplashScreen.route
    ) {
        composable(AppScreens.SplashScreen.route) {
            NavSplash(navController, store.value)
        }
        composable(AppScreens.MainOnBoarding.route) {
            MainOnBoarding(navController, dataStoreViewModel)
        }
        composable(AppScreens.LoginScreen.route) {
            LoginScreen(navController, loginViewModel)
        }
        composable(AppScreens.RegisterScreen.route) {
            RegisterScreen(navController)
        }
        composable(AppScreens.TasksScreen.route) {
            Tasks()
        }
    }
}
// modificar el getOnBoarding para usar con el viewmodel