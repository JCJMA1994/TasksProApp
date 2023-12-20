package com.systemfailed.taskspro.presentation.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.systemfailed.taskspro.presentation.navigation.AppScreens
import com.systemfailed.taskspro.presentation.theme.BlueLight
import com.systemfailed.taskspro.presentation.theme.GreenLight
import com.systemfailed.taskspro.presentation.theme.PoppinsFont
import kotlinx.coroutines.delay

@Composable
fun NavSplash(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(5000)
        navController.popBackStack()
        navController.navigate(AppScreens.LoginScreen.route)
    }
    SplashScreen()
}

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(color = GreenLight),
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
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = BlueLight,
                        textDecoration = TextDecoration.Underline
                    )
                ) {
                    append("Tasks")
                }
                append("Pro")
            },
            fontSize = 40.sp,
            fontFamily = PoppinsFont,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
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