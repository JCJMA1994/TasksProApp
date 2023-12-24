package com.systemfailed.taskspro.common.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun CustomSocial(
    iconSocial: Painter,
    contentDescription: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .myCustomModifierSocial()
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = iconSocial,
            contentDescription = contentDescription,
            modifier = Modifier.size(32.dp)
        )

    }
}


@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.myCustomModifierSocial() = composed {
    Modifier.clip(RoundedCornerShape(8.dp))

}
