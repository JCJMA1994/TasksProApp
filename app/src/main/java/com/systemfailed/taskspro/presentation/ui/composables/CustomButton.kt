package com.systemfailed.taskspro.presentation.ui.composables

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier,
    colors: ButtonColors
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        colors = colors
    ) {
        Text(text = text)
    }

}