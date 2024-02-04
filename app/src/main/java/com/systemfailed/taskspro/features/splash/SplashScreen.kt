package com.systemfailed.taskspro.features.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.systemfailed.taskspro.common.components.CustomTextApp
import com.systemfailed.taskspro.navigation.AppScreens
import com.systemfailed.taskspro.theme.BlueLight
import com.systemfailed.taskspro.theme.GreenLight
import kotlinx.coroutines.delay

@Composable
fun NavSplash(navController: NavController, store: Boolean) {
    var screen by remember {
        mutableStateOf("")
    }
    screen = if (store) {
        AppScreens.LoginScreen.route
    } else {
        AppScreens.MainOnBoarding.route
    }

    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate(screen)
    }
    SplashScreen()
}

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(color = GreenLight)
            .systemBarsPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Filled.AddTask,
            contentDescription = "",
            tint = BlueLight,
            modifier = Modifier
                .size(72.dp)
        )
        CustomTextApp(
            text = "Tasks",
            textStyle = MaterialTheme.typography.displayLarge.copy(
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 64.sp
            )
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}