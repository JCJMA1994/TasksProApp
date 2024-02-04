package com.systemfailed.taskspro.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.systemfailed.taskspro.R

@Composable
fun CustomImageLogo() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.fastify),
            contentDescription = "Logo",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .size(160.dp)
                .align(Alignment.CenterHorizontally)
        )
        CustomTextApp(
            text = "Tasks",
            textStyle = MaterialTheme.typography.displayLarge.copy(
                color = Color.Black,
                fontSize = 64.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}