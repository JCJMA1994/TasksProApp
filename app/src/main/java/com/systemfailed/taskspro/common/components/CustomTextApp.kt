package com.systemfailed.taskspro.common.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.systemfailed.taskspro.theme.BlueLight
import com.systemfailed.taskspro.theme.PoppinsFont

@Composable
fun CustomTextApp() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = BlueLight,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("Tasks")
            }
            append("Pro")
        },
        fontSize = 40.sp,
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        modifier = Modifier
            .padding(16.dp)
    )
}