package com.systemfailed.taskspro.common.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    colors: ButtonColors
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        colors = colors
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            fontWeight = fontWeight
        )
    }

}