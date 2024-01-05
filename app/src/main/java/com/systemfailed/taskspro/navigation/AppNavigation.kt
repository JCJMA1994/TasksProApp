package com.systemfailed.taskspro.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.systemfailed.taskspro.features.auth.presentation.ui.LoginScreen
import com.systemfailed.taskspro.features.auth.presentation.ui.RegisterScreen
import com.systemfailed.taskspro.features.auth.presentation.viewmodel.AuthViewModel
import com.systemfailed.taskspro.features.home.presentation.ui.HomeScreen
import com.systemfailed.taskspro.features.onboarding.presentation.MainOnBoarding
import com.systemfailed.taskspro.features.onboarding.presentation.viewmodel.DataStoreViewModel
import com.systemfailed.taskspro.features.profile.presentation.ui.ProfileScreen
import com.systemfailed.taskspro.features.splash.NavSplash
import com.systemfailed.taskspro.features.tasks.presentation.ui.TasksScreen

@Composable
fun AppNavigation(controller: NavHostController) {
    //val navController = rememberNavController()

    val authViewModel: AuthViewModel = viewModel()
    val dataStoreViewModel: DataStoreViewModel = viewModel()

    val store = dataStoreViewModel.getBoarding.collectAsState(initial = false)

    NavHost(
        navController = controller,
        startDestination = if (store.value) AppScreens.LoginScreen.route else AppScreens.SplashScreen.route
    ) {
        composable(AppScreens.SplashScreen.route) {
            NavSplash(controller, store.value)
        }
        composable(AppScreens.MainOnBoarding.route) {
            MainOnBoarding(controller, dataStoreViewModel)
        }
        composable(AppScreens.LoginScreen.route) {
            LoginScreen(controller, authViewModel)
        }
        composable(AppScreens.RegisterScreen.route) {
            RegisterScreen(controller, authViewModel)
        }
        composable(AppScreens.HomeScreen.route) {
            HomeScreen(controller)
        }
        composable(AppScreens.TasksScreen.route) {
            TasksScreen()
        }
        composable(AppScreens.ProfileScreen.route) {
            ProfileScreen()
        }

    }
}
