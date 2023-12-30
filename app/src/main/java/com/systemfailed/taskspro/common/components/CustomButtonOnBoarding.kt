package com.systemfailed.taskspro.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.systemfailed.taskspro.features.onboarding.presentation.viewmodel.DataStoreViewModel
import com.systemfailed.taskspro.navigation.AppScreens

@Composable
fun CustomButtonOnBoarding(
    currentPage: Int,
    navController: NavController,
    dataStoreViewModel: DataStoreViewModel
) {

    Row(
        modifier = Modifier
            .padding(bottom = 24.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (currentPage != 2) Arrangement.SpaceBetween else Arrangement.Center
    ) {
        if (currentPage == 2) {
            OutlinedButton(
                onClick = {
                    /* CoroutineScope(Dispatchers.IO).launch {
                         store.saveOnBoarding(true)
                     }*/
                    dataStoreViewModel.saveOnBoarding(true)
                    navController.navigate(AppScreens.LoginScreen.route)
                }
            ) {
                Text(
                    text = "Go",
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 40.dp),
                    color = Color.Gray
                )
            }
        }
    }
}