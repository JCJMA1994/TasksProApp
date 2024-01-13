package com.systemfailed.taskspro.features.tasks.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.systemfailed.taskspro.common.components.CustomTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksScreen() {
    CustomTopAppBar(
        title = {
            Text(
                text = "Tasks",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        actionsContent = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Refresh")
            }
        },
    ) {

    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PreviewTask() {
    TasksScreen()
}