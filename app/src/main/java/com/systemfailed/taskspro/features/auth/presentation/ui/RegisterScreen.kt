package com.systemfailed.taskspro.features.auth.presentation.ui

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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.systemfailed.taskspro.common.components.CustomButton
import com.systemfailed.taskspro.common.components.CustomDivider
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

@Composable
fun RegisterScreen(navController: NavController, authViewModel: AuthViewModel) {
    Column(
        modifier = Modifier
            .background(LightGray)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 24.dp, end = 24.dp, top = 16.dp)

    ) {
        CustomHeader(imageVector = Icons.Filled.ArrowBack,
            contentDescription = "close app",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.TopStart)
                .padding(bottom = 24.dp)
                .clickable {
                    navController.popBackStack()
                })
        BodyRegister(navController, authViewModel)
    }
}


@Composable
fun BodyRegister(navController: NavController, authViewModel: AuthViewModel) {
    val username: String by authViewModel.username.observeAsState(initial = "")
    val name: String by authViewModel.name.observeAsState(initial = "")
    val lastname: String by authViewModel.lastname.observeAsState(initial = "")
    val email: String by authViewModel.email.observeAsState(initial = "")
    val password: String by authViewModel.password.observeAsState(initial = "")

    val isRegisterEnable: Boolean by authViewModel.isRegisterEnable.observeAsState(initial = false)

    val context = LocalContext.current

    var isPasswordVisible by remember { mutableStateOf(false) }

    val imagen = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

    CustomImageLogo()
    CustomSpacer(16.dp)
    CustomTextField(
        value = username,
        placeholder = "Enter your username",
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text
        ),
        leadingIcon = Icons.Filled.PermIdentity,
        onTextChanged = {
            authViewModel.onRegisterChanged(username = it, name, lastname, email, password)
        },
        visualTransformation = VisualTransformation.None

    )
    CustomSpacer(16.dp)
    CustomTextField(
        value = name,
        placeholder = "Enter your name",
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text
        ),
        leadingIcon = Icons.Filled.Person,
        onTextChanged = {
            authViewModel.onRegisterChanged(username, name = it, lastname, email, password)
        },
        visualTransformation = VisualTransformation.None
    )
    CustomSpacer(16.dp)
    CustomTextField(
        value = lastname,
        placeholder = "Enter your lastname",
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text
        ),
        leadingIcon = Icons.Filled.Person,
        onTextChanged = {
            authViewModel.onRegisterChanged(username, name, lastname = it, email, password)
        },
        visualTransformation = VisualTransformation.None
    )
    CustomSpacer(16.dp)
    CustomTextField(
        value = email,
        placeholder = "Enter your email",
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ),
        leadingIcon = Icons.Filled.Email,
        onTextChanged = {
            authViewModel.onRegisterChanged(username, name, lastname, email = it, password)
        },
        visualTransformation = VisualTransformation.None
    )
    CustomSpacer(16.dp)
    CustomTextField(
        value = password,
        placeholder = "Enter your password",
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Go,
            keyboardType = KeyboardType.Password
        ),
        leadingIcon = Icons.Filled.Password,
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(imageVector = imagen, contentDescription = null)
            }
        },
        onTextChanged = {
            authViewModel.onRegisterChanged(username, name, lastname, email, password = it)
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
    CustomSpacer(16.dp)
    CustomButton(
        text = "Sign up", fontSize = 16.sp, fontWeight = FontWeight.Bold, onClick = {
            authViewModel.onRegisterSelected {
                navController.navigate(AppScreens.TasksScreen.route)
            }
        }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
            containerColor = GreenLight,
            disabledContainerColor = Color(0xFF78C8F9),
            contentColor = BlueDark,
            disabledContentColor = Color.White
        ), enabled = isRegisterEnable
    )
    CustomSpacer(8.dp)
    CustomDivider()
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
