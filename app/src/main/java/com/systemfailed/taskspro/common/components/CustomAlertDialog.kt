package com.systemfailed.taskspro.common.components

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.systemfailed.taskspro.theme.BlueDark
import com.systemfailed.taskspro.theme.GreenLight


@Composable
fun CustomAlertDialog(
    title: String,
    message: String,
    confirmText: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
) {
    val scroll = rememberScrollState(0)

    AlertDialog(onDismissRequest = { onDismissClick() },
        title = { Text(text = title) },
        text = {
            Text(
                text = message,
                textAlign = TextAlign.Justify,
                color = Color.Black,
                modifier = Modifier.verticalScroll(scroll)
            )
        },
        confirmButton = {
            Button(
                onClick = { onConfirmClick() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenLight,
                    disabledContainerColor = Color(0xFF78C8F9),
                    contentColor = BlueDark,
                    disabledContentColor = Color.White
                ),
            ) {
                Text(
                    text = confirmText,
                    color = Color.Black
                )
            }
        })
}