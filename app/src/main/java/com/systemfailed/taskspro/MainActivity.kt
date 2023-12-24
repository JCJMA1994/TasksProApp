package com.systemfailed.taskspro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.systemfailed.taskspro.navigation.AppNavigation
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
                    AppNavigation()
                }
            }
        }

    }
}