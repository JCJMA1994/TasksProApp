package com.systemfailed.taskspro.common.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.systemfailed.taskspro.theme.GreenLight
import com.systemfailed.taskspro.theme.WhiteLight


@Composable
fun CustomTextField(
    value: String,
    placeholder: String,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions,
    singleLine: Boolean = true,
    leadingIcon: ImageVector,
    trailingIcon: (@Composable () -> Unit)? = null,
    onTextChanged: (String) -> Unit,
    shape: CutCornerShape = remember { CutCornerShape(topStart = 15.dp, topEnd = 10.dp) },
    colors: TextFieldColors = TextFieldDefaults.colors(
        focusedIndicatorColor = GreenLight,
        unfocusedIndicatorColor = Color.Transparent,
        focusedTextColor = Color.Black,
        cursorColor = GreenLight,
        //container
        focusedContainerColor = GreenLight,
        unfocusedContainerColor = WhiteLight,
        focusedLabelColor = WhiteLight
    ),
    visualTransformation: VisualTransformation
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
        colors = colors,
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
            )
        },
        trailingIcon = trailingIcon,
        shape = shape,
        onValueChange = onTextChanged,
        visualTransformation = visualTransformation,
    )

}

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.myCustomModifier() = composed {
    Modifier
        .fillMaxWidth()
}

