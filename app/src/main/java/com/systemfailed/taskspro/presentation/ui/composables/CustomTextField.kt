package com.systemfailed.taskspro.presentation.ui.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomTextField(
    value: String,
    placeholder: String,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions,
    singleLine: Boolean = true,
    icon: ImageVector,
    onTextChanged: (String) -> Unit
) {
    TextField(
        value = value,
        modifier = Modifier.myCustomModifier(),
        placeholder = {
            Text(
                text = placeholder,
                fontSize = 12.sp
            )
        },
        keyboardOptions = keyboardOptions,
        maxLines = maxLines,
        singleLine = singleLine,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        trailingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        },
        onValueChange = onTextChanged
    )
}

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.myCustomModifier() = composed {
    Modifier
        .fillMaxWidth()
        .border(
            color = Color.Gray,
            width = 1.dp,
            shape = RoundedCornerShape(8.dp)
        )
}

