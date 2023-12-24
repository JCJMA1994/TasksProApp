package com.systemfailed.taskspro.features.auth.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.systemfailed.taskspro.common.components.CustomButton
import com.systemfailed.taskspro.common.components.CustomSpacer
import com.systemfailed.taskspro.common.components.CustomTextApp
import com.systemfailed.taskspro.common.components.CustomTextField
import com.systemfailed.taskspro.navigation.AppScreens
import com.systemfailed.taskspro.theme.BlueDark
import com.systemfailed.taskspro.theme.GreenLight
import com.systemfailed.taskspro.theme.PoppinsFont

@Composable
fun RegisterScreen(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                24.dp
            )
    ) {

        val name = remember {
            mutableStateOf("")
        }
        val email = remember {
            mutableStateOf("")
        }
        val password = remember {
            mutableStateOf("")
        }
        val confirmPassword = remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Column(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                CustomTextApp()
                Text(
                    text = "Register",
                    fontSize = 40.sp,
                    fontFamily = PoppinsFont,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
            }


            CustomSpacer(24)
            CustomTextField(
                value = name.value,
                placeholder = "Enter your name",
                keyboardOptions = KeyboardOptions.Default,
                leadingIcon = Icons.Filled.Person,
                trailingIcon = Icons.Filled.Send,
                onTextChanged = {

                }

            )
            CustomSpacer(24)
            CustomTextField(
                value = email.value,
                placeholder = "Enter your email",
                keyboardOptions = KeyboardOptions.Default,
                leadingIcon = Icons.Filled.Email,
                trailingIcon = Icons.Filled.Send,
                onTextChanged = {

                }
            )
            CustomSpacer(24)
            CustomTextField(
                value = password.value,
                placeholder = "Enter your password",
                keyboardOptions = KeyboardOptions.Default,
                leadingIcon = Icons.Filled.Password,
                trailingIcon = Icons.Filled.Visibility,
                onTextChanged = {

                }
            )
            CustomSpacer(24)
            CustomTextField(
                value = confirmPassword.value,
                placeholder = "Confirm your name",
                keyboardOptions = KeyboardOptions.Default,
                leadingIcon = Icons.Filled.Password,
                trailingIcon = Icons.Filled.Visibility,
                onTextChanged = {

                }
            )
            CustomSpacer(24)
            CustomButton(
                text = "Sign up",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                onClick = {
                    navController.navigate(AppScreens.TasksScreen.route)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenLight,
                    disabledContainerColor = Color(0xFF78C8F9),
                    contentColor = BlueDark,
                    disabledContentColor = Color.White
                )
            )
        }
    }
}

/*
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}*/
