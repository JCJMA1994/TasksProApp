package com.systemfailed.taskspro.features.tasks.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.systemfailed.taskspro.common.components.CustomTextApp

@Composable
fun Tasks() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
    ) {
        CustomTextApp()
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun TasksPreview() {
    Tasks()
}