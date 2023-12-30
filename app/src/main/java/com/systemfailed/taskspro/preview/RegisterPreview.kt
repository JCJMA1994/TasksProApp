package com.systemfailed.taskspro.preview

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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.systemfailed.taskspro.common.components.CustomHeader
import com.systemfailed.taskspro.common.components.CustomImageLogo
import com.systemfailed.taskspro.common.components.CustomSocial
import com.systemfailed.taskspro.common.components.CustomSpacer
import com.systemfailed.taskspro.common.components.CustomTextField
import com.systemfailed.taskspro.theme.BlueDark
import com.systemfailed.taskspro.theme.GreenLight
import com.systemfailed.taskspro.theme.LightGray

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RegisterPreview() {
    Column(
        modifier = Modifier
            .background(LightGray)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 24.dp, end = 24.dp, top = 16.dp)

    ) {
        CustomHeader(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "close app",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.TopStart)
                .padding(bottom = 24.dp)
                .clickable {

                }
        )
        BodyRegisterP()
    }

}

@Composable
fun BodyRegisterP() {
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
    val context = LocalContext.current
    CustomImageLogo()
    CustomSpacer(16.dp)
    CustomTextField(
        value = name.value,
        placeholder = "Enter your name",
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = Icons.Filled.Person,
        trailingIcon = Icons.Filled.Send,
        onTextChanged = {

        }

    )
    CustomSpacer(16.dp)
    CustomTextField(
        value = email.value,
        placeholder = "Enter your email",
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = Icons.Filled.Email,
        trailingIcon = Icons.Filled.Send,
        onTextChanged = {

        }
    )
    CustomSpacer(16.dp)
    CustomTextField(
        value = password.value,
        placeholder = "Enter your password",
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = Icons.Filled.Password,
        trailingIcon = Icons.Filled.Visibility,
        onTextChanged = {

        }
    )
    CustomSpacer(16.dp)
    CustomTextField(
        value = confirmPassword.value,
        placeholder = "Confirm your name",
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = Icons.Filled.Password,
        trailingIcon = Icons.Filled.Visibility,
        onTextChanged = {

        }
    )
    CustomSpacer(16.dp)
    CustomButton(
        text = "Sign up",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        onClick = {
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenLight,
            disabledContainerColor = Color(0xFF78C8F9),
            contentColor = BlueDark,
            disabledContentColor = Color.White
        )
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
