package com.systemfailed.taskspro.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomIndicator(size: Int, curretPage: Int) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 60.dp)
    ) {
        repeat(size) {
            Indicator(isSelect = it == curretPage)
        }
    }
}


@Composable
fun Indicator(isSelect: Boolean) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .height(10.dp)
            .width(25.dp)
            .clip(CircleShape)
            .background(if (isSelect) Color.Red else Color.Gray)
    )
}