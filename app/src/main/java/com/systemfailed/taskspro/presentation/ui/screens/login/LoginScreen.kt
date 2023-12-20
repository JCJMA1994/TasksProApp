package com.systemfailed.taskspro.presentation.ui.screens.login

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.systemfailed.taskspro.R
import com.systemfailed.taskspro.presentation.theme.BlueDark
import com.systemfailed.taskspro.presentation.theme.BlueLight
import com.systemfailed.taskspro.presentation.theme.GreenLight
import com.systemfailed.taskspro.presentation.ui.composables.CustomButton
import com.systemfailed.taskspro.presentation.ui.composables.CustomSpacer
import com.systemfailed.taskspro.presentation.ui.composables.CustomTextField
import kotlin.system.exitProcess

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                24.dp
            )
    ) {
        Header(
            Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        )
        Body(Modifier.align(Alignment.Center))
        Footer(Modifier.align(Alignment.BottomCenter))
    }

}

@Composable
fun Body(modifier: Modifier) {
    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }
    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        CustomSpacer(16)
        CustomTextField(
            value = email.value,
            onTextChanged = {
                email.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            placeholder = "Phone number, username or email",
            icon = Icons.Filled.Email

        )
        CustomSpacer(8)
        CustomTextField(
            value = password.value, onTextChanged = {
                password.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = "Password",
            icon = Icons.Filled.Password
        )
        CustomSpacer(8)
        ForgotPassword(Modifier.align(Alignment.End))
        CustomSpacer(8)
        CustomButton(
            text = "Log in",
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = GreenLight,
                disabledContainerColor = Color(0xFF78C8F9),
                contentColor = BlueDark,
                disabledContentColor = Color.White
            )
        )
        CustomSpacer(8)
        LoginDivider()
        CustomSpacer(16)
        SocialLogin()
    }
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.tasks),
        contentDescription = "Logo",
        modifier = modifier
    )
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forget password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = BlueLight,
        modifier = modifier
    )
}

@Composable
fun Header(modifier: Modifier) {
    // val activity = LocalContext.current.asActivityOrNull()
    //if (activity != null) {
    Icon(
        imageVector = Icons.Default.Close,
        tint = Color.Black,
        contentDescription = "close app",
        modifier = modifier.clickable { exitProcess(0) })
    // }
}

/*fun Context.asActivityOrNull(): Activity? {
    return if (this is Activity) this else null
}*/

@Composable
fun Footer(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .fillMaxWidth()
        )
        CustomSpacer(16)
        SignUp()
        CustomSpacer(16)

    }
}

@Composable
fun SignUp() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = "Don't have an account?", fontSize = 12.sp,
            color = Color(0xFFB5B5B5)
        )
        Text(
            text = "Sign up.", Modifier.padding(horizontal = 12.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
fun SocialLogin() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            imageVector = Icons.Filled.Facebook,
            contentDescription = "Social Login FB",
            modifier = Modifier.size(32.dp)
        )
        Text(
            text = "Continue as Joao",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
fun LoginDivider() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}