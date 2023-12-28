package com.systemfailed.taskspro.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.systemfailed.taskspro.navigation.AppScreens
import com.systemfailed.taskspro.theme.PrimaryBlack


@Composable
fun CustomFooter(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Don't have an account?",
            fontSize = 16.sp,
            color = PrimaryBlack
        )
        Text(
            text = "Sign up.",
            Modifier
                .padding(horizontal = 16.dp)
                .clickable {
                    navController.navigate(AppScreens.RegisterScreen.route)
                }, fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryBlack
        )
    }
}