package com.systemfailed.taskspro.common.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomSpacer(size: Dp = 8.dp) {
    Spacer(modifier = Modifier.size(size))
}