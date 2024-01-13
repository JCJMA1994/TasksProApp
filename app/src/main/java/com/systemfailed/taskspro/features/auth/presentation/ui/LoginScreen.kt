package com.systemfailed.taskspro.features.auth.presentation.ui

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.systemfailed.taskspro.R
import com.systemfailed.taskspro.common.components.CustomAlertDialog
import com.systemfailed.taskspro.common.components.CustomButton
import com.systemfailed.taskspro.common.components.CustomDivider
import com.systemfailed.taskspro.common.components.CustomFooter
import com.systemfailed.taskspro.common.components.CustomHeader
import com.systemfailed.taskspro.common.components.CustomImageLogo
import com.systemfailed.taskspro.common.components.CustomSocial
import com.systemfailed.taskspro.common.components.CustomSpacer
import com.systemfailed.taskspro.common.components.CustomTextField
import com.systemfailed.taskspro.features.auth.presentation.viewmodel.AuthViewModel
import com.systemfailed.taskspro.navigation.AppScreens
import com.systemfailed.taskspro.theme.BlueDark
import com.systemfailed.taskspro.theme.GreenLight
import com.systemfailed.taskspro.theme.LightGray
import com.systemfailed.taskspro.theme.PrimaryBlack

@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel) {
    val activity = LocalContext.current as? Activity
    val isLoading: Boolean by authViewModel.isLoading.observeAsState(initial = false)

    Column(
        modifier = Modifier
            .background(LightGray)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 72.dp, bottom = 24.dp, start = 24.dp, end = 24.dp)

    ) {
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                CircularProgressIndicator()
            }
        } else {
            CustomHeader(imageVector = Icons.Default.Close,
                contentDescription = "close app",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.TopEnd)
                    .padding(bottom = 24.dp)
                    .clickable {
                        activity?.finish()
                    })
            BodyLogin(navController, authViewModel)
            CustomSpacer(32.dp)
            CustomFooter(navController)
        }
    }
}


@Composable
fun BodyLogin(navController: NavController, authViewModel: AuthViewModel) {
    val email: String by authViewModel.email.observeAsState(initial = "")
    val password: String by authViewModel.password.observeAsState(initial = "")
    val isLoginEnable: Boolean by authViewModel.isLoginEnable.observeAsState(initial = false)

    val loginAlert: Boolean by authViewModel.loginAlert.observeAsState(initial = false)

    var passwordVisibility by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    CustomImageLogo()
    CustomSpacer(16.dp)
    CustomTextField(
        value = email,
        onTextChanged = {
            authViewModel.onLoginChanged(email = it, password = password)
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ),
        placeholder = "Phone number, username or email",
        leadingIcon = Icons.Filled.Email,
        visualTransformation = VisualTransformation.None
    )
    CustomSpacer()
    val imagen = if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
    CustomTextField(
        value = password,
        onTextChanged = {
            authViewModel.onLoginChanged(email = email, password = it)
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Go,
            keyboardType = KeyboardType.Password
        ),
        placeholder = "Password",
        leadingIcon = Icons.Filled.Password,
        trailingIcon = {
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = imagen, contentDescription = null)
            }
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()
    )
    CustomSpacer()
    ForgotPassword(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.BottomEnd)
    )
    CustomSpacer(16.dp)
    CustomButton(
        text = "Log in", fontSize = 16.sp, fontWeight = FontWeight.Bold,
        onClick = {
            authViewModel.onLoginSelected {
                navController.navigate(AppScreens.HomeScreen.route)
            }

        }, modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenLight,
            disabledContainerColor = Color(0xFF78C8F9),
            contentColor = BlueDark,
            disabledContentColor = Color.White
        ),
        enabled = isLoginEnable
    )
    if (loginAlert) {
        CustomAlertDialog(
            title = "Alerta",
            message = "Usuario y/o Contrasena Incorrecto",
            confirmText = "Aceptar",
            onConfirmClick = { authViewModel.closureAlert() }) {

        }
    }

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