package com.systemfailed.taskspro.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Task
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

sealed class TopLevelDestination(
    val route: String,
    val iconTexId: String,
    val selectIcon: @Composable () -> Unit
) {
    data object Home : TopLevelDestination(
        route = AppScreens.HomeScreen.route,
        iconTexId = "Home",
        selectIcon = {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Home Icon"
            )
        }
    )

    data object Task : TopLevelDestination(
        route = AppScreens.TasksScreen.route,
        iconTexId = "Task",
        selectIcon = {
            Icon(
                imageVector = Icons.Filled.Task,
                contentDescription = "Task Icon"
            )
        }
    )

    data object Profile : TopLevelDestination(
        route = AppScreens.ProfileScreen.route,
        iconTexId = "Profile",
        selectIcon = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Person Icon"
            )
        }
    )

}

val navItems = listOf(
    TopLevelDestination.Home,
    TopLevelDestination.Task,
    TopLevelDestination.Profile
)