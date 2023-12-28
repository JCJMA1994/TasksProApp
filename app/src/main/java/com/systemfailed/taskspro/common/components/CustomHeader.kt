package com.systemfailed.taskspro.common.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector


@Composable
fun CustomHeader(
    imageVector: ImageVector,
    contentDescription: String,
    modifier: Modifier
) {
    Icon(
        imageVector = imageVector,
        tint = Color.Black,
        contentDescription = contentDescription,
        modifier = modifier
    )
}