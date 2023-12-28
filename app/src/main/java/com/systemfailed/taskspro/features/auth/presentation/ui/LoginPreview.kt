package com.systemfailed.taskspro.features.auth.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.systemfailed.taskspro.R
import com.systemfailed.taskspro.common.components.CustomButton
import com.systemfailed.taskspro.common.components.CustomDivider
import com.systemfailed.taskspro.common.components.CustomImageLogo
import com.systemfailed.taskspro.common.components.CustomSocial
import com.systemfailed.taskspro.common.components.CustomSpacer
import com.systemfailed.taskspro.common.components.CustomTextField
import com.systemfailed.taskspro.theme.BlueDark
import com.systemfailed.taskspro.theme.GreenLight
import com.systemfailed.taskspro.theme.PrimaryBlack
import kotlin.system.exitProcess

@Composable
fun LoginPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top =72.dp, bottom = 8.dp, start = 24.dp, end = 24.dp)
    ) {
        HeaderP()
        BodyP()
        CustomSpacer(32.dp)
        FooterP()
    }
}

@Composable
fun HeaderP() {
    Icon(
        imageVector = Icons.Default.Close,
        tint = Color.Black,
        contentDescription = "close app",
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
            .padding(bottom = 24.dp)
            .clickable { exitProcess(0) }
    )
}

@Composable
fun BodyP() {
    val context = LocalContext.current
    CustomImageLogo()
    CustomSpacer()
    CustomTextField(
        value = "value",
        placeholder = "Text",
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = Icons.Filled.Email,
        trailingIcon = Icons.Filled.Send,
        onTextChanged = {}
    )
    CustomSpacer()
    CustomTextField(
        value = "value",
        placeholder = "Text",
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = Icons.Filled.Email,
        trailingIcon = Icons.Filled.Send,
        onTextChanged = {}
    )
    CustomSpacer()
    ForgotPassword(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.BottomEnd)
    )
    CustomSpacer()
    CustomButton(
        text = "Log in",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        onClick = {
            // loginViewModel.onLoginSelected()
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenLight,
            disabledContainerColor = Color(0xFF78C8F9),
            contentColor = BlueDark,
            disabledContentColor = Color.White
        )
    )
    CustomSpacer(32.dp)
    CustomDivider()
    CustomSpacer()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        CustomSocial(iconSocial = painterResource(id = R.drawable.ic_facebook),
            contentDescription = "icon Facebook",
            onClick = {
                Toast.makeText(context, "Facebook", Toast.LENGTH_LONG).show()
            })
        CustomSocial(iconSocial = painterResource(id = R.drawable.ic_google),
            contentDescription = "icon Google",
            onClick = {
                Toast.makeText(context, "Google", Toast.LENGTH_LONG).show()
            })
        CustomSocial(iconSocial = painterResource(id = R.drawable.ic_instagram),
            contentDescription = "icon Instagram",
            onClick = {
                Toast.makeText(context, "Instagram", Toast.LENGTH_LONG).show()
            })
        CustomSocial(iconSocial = painterResource(id = R.drawable.ic_x),
            contentDescription = "icon X",
            onClick = {
                Toast.makeText(context, "X", Toast.LENGTH_LONG).show()
            })
    }

}

@Composable
fun FooterP() {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Don't have an account?", fontSize = 16.sp, color = PrimaryBlack
        )
        Text(
            text = "Sign up.",
            Modifier
                .padding(horizontal = 16.dp)
                .clickable {
                    //  navController.navigate(AppScreens.RegisterScreen.route)
                }, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = PrimaryBlack
        )
    }
}


@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun LoginP() {
    LoginPreview()
}