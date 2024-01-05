package com.systemfailed.taskspro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.systemfailed.taskspro.navigation.AppNavigation
import com.systemfailed.taskspro.navigation.MyBottonNavigationBar
import com.systemfailed.taskspro.navigation.navItems
import com.systemfailed.taskspro.theme.LightGray
import com.systemfailed.taskspro.theme.TasksProTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSize = calculateWindowSizeClass(this)
            TasksProTheme(
                windowSize = windowSize.widthSizeClass
            ) {
                Surface(
                    color = LightGray
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colorScheme.background),
                        contentAlignment = Alignment.Center
                    ) {
                        val navController = rememberNavController()
                        val navBackStackEntry = navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry.value?.destination
                        AppNavigation(navController)
                        AnimatedVisibility(
                            visible = navItems.any {
                                it.route == currentDestination?.route
                            },
                            modifier = Modifier.align(Alignment.BottomCenter),
                            enter = slideInVertically { it },
                            exit = slideOutVertically { it },
                        ) {
                            MyBottonNavigationBar(navController, currentDestination)
                        }
                    }
                }
            }

        }
    }
}
