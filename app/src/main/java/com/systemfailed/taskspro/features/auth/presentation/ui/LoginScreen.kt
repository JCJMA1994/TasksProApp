package com.systemfailed.taskspro.features.auth.presentation.ui

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.systemfailed.taskspro.R
import com.systemfailed.taskspro.common.components.CustomButton
import com.systemfailed.taskspro.common.components.CustomDivider
import com.systemfailed.taskspro.common.components.CustomFooter
import com.systemfailed.taskspro.common.components.CustomHeader
import com.systemfailed.taskspro.common.components.CustomImageLogo
import com.systemfailed.taskspro.common.components.CustomSocial
import com.systemfailed.taskspro.common.components.CustomSpacer
import com.systemfailed.taskspro.common.components.CustomTextField
import com.systemfailed.taskspro.features.auth.presentation.viewmodel.LoginViewModel
import com.systemfailed.taskspro.navigation.AppScreens
import com.systemfailed.taskspro.theme.BlueDark
import com.systemfailed.taskspro.theme.GreenLight
import com.systemfailed.taskspro.theme.LightGray
import com.systemfailed.taskspro.theme.PrimaryBlack

@Composable
fun LoginScreen(navController: NavController, loginViewModel: LoginViewModel) {
    val activity = LocalContext.current as? Activity
    Column(
        modifier = Modifier
            .background(LightGray)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 72.dp, bottom = 24.dp, start = 24.dp, end = 24.dp)

    ) {
        CustomHeader(
            imageVector = Icons.Default.Close,
            contentDescription = "close app",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.TopEnd)
                .padding(bottom = 24.dp)
                .clickable {
                    activity?.finish()
                }
        )
        BodyLogin(navController, loginViewModel)
        CustomSpacer(32.dp)
        CustomFooter(navController)
    }

}

@Composable
fun BodyLogin(navController: NavController, loginViewModel: LoginViewModel) {
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")

    val context = LocalContext.current

    CustomImageLogo()
    CustomSpacer(16.dp)
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
    CustomSpacer()
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
    CustomSpacer()
    ForgotPassword(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.BottomEnd)
    )
    CustomSpacer(16.dp)
    CustomButton(
        text = "Log in",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        onClick = {
            loginViewModel.onLoginSelected() {
                navController.navigate(AppScreens.TasksScreen.route)
            }

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
    CustomSpacer(16.dp)
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
                Toast.makeText(context, "Facebook", Toast.LENGTH_SHORT).show()
            })
        CustomSocial(iconSocial = painterResource(id = R.drawable.ic_google),
            contentDescription = "icon Google",
            onClick = {
                Toast.makeText(context, "Google", Toast.LENGTH_SHORT).show()
            })
        CustomSocial(iconSocial = painterResource(id = R.drawable.ic_instagram),
            contentDescription = "icon Instagram",
            onClick = {
                Toast.makeText(context, "Instagram", Toast.LENGTH_SHORT).show()
            })
        CustomSocial(iconSocial = painterResource(id = R.drawable.ic_x),
            contentDescription = "icon X",
            onClick = {
                Toast.makeText(context, "X", Toast.LENGTH_SHORT).show()
            })
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