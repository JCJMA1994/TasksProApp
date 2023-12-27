package com.systemfailed.taskspro.features.auth.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.systemfailed.taskspro.R
import com.systemfailed.taskspro.common.components.CustomButton
import com.systemfailed.taskspro.common.components.CustomSocial
import com.systemfailed.taskspro.common.components.CustomSpacer
import com.systemfailed.taskspro.common.components.CustomTextApp
import com.systemfailed.taskspro.common.components.CustomTextField
import com.systemfailed.taskspro.features.auth.presentation.viewmodel.AuthViewModel
import com.systemfailed.taskspro.navigation.AppScreens
import com.systemfailed.taskspro.theme.BlueDark
import com.systemfailed.taskspro.theme.GreenLight
import com.systemfailed.taskspro.theme.LightGray
import com.systemfailed.taskspro.theme.PrimaryBlack
import kotlin.system.exitProcess

@Composable
fun LoginScreen(navController: NavController, loginViewModel: AuthViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                24.dp
            )
            .background(LightGray)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center), loginViewModel)
        Footer(Modifier.align(Alignment.BottomCenter), navController)
    }

}

@Composable
fun Header(modifier: Modifier) {
    Icon(imageVector = Icons.Default.Close,
        tint = Color.Black,
        contentDescription = "close app",
        modifier = modifier.clickable { exitProcess(0) })
    // }
}

@Composable
fun Body(modifier: Modifier, loginViewModel: AuthViewModel) {
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")

    val context = LocalContext.current

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        CustomSpacer(16)
        CustomTextField(
            value = email,
            onTextChanged = {
                loginViewModel.onLoginChanged(email = it, password = password)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            placeholder = "Phone number, username or email",
            leadingIcon = Icons.Filled.Email,
            trailingIcon = Icons.Filled.Send
        )
        CustomSpacer(8)
        CustomTextField(
            value = password,
            onTextChanged = {
                loginViewModel.onLoginChanged(email = email, password = it)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = "Password",
            leadingIcon = Icons.Filled.Password,
            trailingIcon = Icons.Filled.Visibility
        )
        CustomSpacer(8)
        ForgotPassword(Modifier.align(Alignment.End))
        CustomSpacer(16)
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
        CustomSpacer(32)
        LoginDivider()
        CustomSpacer(16)
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

}

@Composable
fun ImageLogo(modifier: Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                4.dp
            )
    ) {
        CustomTextApp()
        Image(
            painter = painterResource(id = R.drawable.fastify),
            contentDescription = "Logo",
            modifier = modifier,
            contentScale = ContentScale.FillWidth
        )
    }

}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forget password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = PrimaryBlack,
        modifier = modifier
    )
}

@Composable
fun LoginDivider() {
    Row(
        Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "Or Login With",
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 12.sp,
            color = PrimaryBlack
        )
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun Footer(modifier: Modifier, navController: NavController) {
    Row(
        modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Don't have an account?", fontSize = 16.sp, color = PrimaryBlack
        )
        Text(
            text = "Sign up.",
            Modifier
                .padding(horizontal = 16.dp)
                .clickable {
                    navController.navigate(AppScreens.RegisterScreen.route)
                }, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = PrimaryBlack
        )
    }
}


/*
@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}*/
