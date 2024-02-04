package com.systemfailed.taskspro.common.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import com.systemfailed.taskspro.theme.BlueLight

@Composable
fun CustomTextApp(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.displayLarge
) {
    var textApp by remember {
        mutableStateOf(textStyle)
    }
    val fontSizeFactor = 0.95
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = BlueLight,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append(text)
            }
            append("Pro")
        },
        softWrap = false,
        style = textApp,
        onTextLayout = { result ->
            if (result.didOverflowWidth) {
                textApp = textStyle.copy(
                    fontSize = textStyle.fontSize * fontSizeFactor)
            }
        },
        modifier = modifier
            .fillMaxWidth()
    )
}