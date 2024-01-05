package com.systemfailed.taskspro.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController

@Composable
fun MyBottonNavigationBar(
    controller: NavHostController,
    currentDestination: NavDestination?
) {
    NavigationBar {
        navItems.forEach { screen ->
            val select = currentDestination?.route == screen.route
            NavigationBarItem(
                selected = select,
                onClick = {
                    controller.navigate(screen.route) {
                        popUpTo(AppScreens.HomeScreen.route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.onBackground
                ),
                icon = if (select) {
                    {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = screen.iconTexId,
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.tertiary
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Box(
                                modifier = Modifier
                                    .size(5.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.tertiary,
                                        shape = CircleShape
                                    )
                            )
                        }
                    }

                } else screen.selectIcon
            )
        }
    }
}