package com.systemfailed.taskspro.common.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.systemfailed.taskspro.theme.Black
import com.systemfailed.taskspro.theme.Cyan
import com.systemfailed.taskspro.theme.CyanSky

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Cyan,
        disabledContainerColor = CyanSky,
        contentColor = Black,
        disabledContentColor = Black
    ),
    enabled: Boolean,
    borderStroke: BorderStroke = BorderStroke(1.dp, Cyan),
) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = modifier,
        colors = colors,
        enabled = enabled,
        border = borderStroke
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            fontWeight = fontWeight
        )
    }

}

