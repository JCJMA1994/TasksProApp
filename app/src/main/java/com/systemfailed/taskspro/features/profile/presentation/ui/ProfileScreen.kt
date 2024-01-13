package com.systemfailed.taskspro.features.profile.presentation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Profile") }) }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(
                vertical = it.calculateTopPadding()
            )
        ) {

        }
    }
}