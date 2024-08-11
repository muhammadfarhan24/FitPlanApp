package com.msv.appfitplanmobile.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.ui.theme.AppFitPlanMobileTheme
import com.msv.appfitplanmobile.R

@Composable
fun LoginScreen(navController: NavController) {
    val viewModel: LoginViewModel = hiltViewModel()
    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.DarkGray)
        ) {
        }
        CustomBackground()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(64.dp))
            var email: String by remember {
                mutableStateOf("")
            }
            var password by remember {
                mutableStateOf("")
            }
            Text(
                text = "Welcome Back To",
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )
            Text(
                text = "Fit Plan!",
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(128.dp))
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email", fontSize = 14.sp) },
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = MaterialTheme.shapes.large
                    )
                    .fillMaxWidth()
                    .height(65.dp), shape = MaterialTheme.shapes.extraLarge,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedContainerColor = Color.DarkGray.copy(alpha = 0.8f),
                    unfocusedContainerColor = Color.DarkGray,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = MaterialTheme.shapes.large
                    )
                    .fillMaxWidth()
                    .height(65.dp), shape = MaterialTheme.shapes.extraLarge,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedContainerColor = Color.DarkGray.copy(alpha = 0.8f),
                    unfocusedContainerColor = Color.DarkGray,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White

                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Forgot Password?",
                color = Color.White,
                modifier = Modifier.align(Alignment.End)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    navController.navigate("gender")
                    viewModel.setLogin(true)
                }, modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .width(260.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF7B58FE)
                ), shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Login", color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Divider(
                    color = Color.White,
                    thickness = 1.dp,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Or",
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Divider(
                    color = Color.White,
                    thickness = 1.dp,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedButton(
                    onClick = { }, modifier = Modifier
                        .height(30.dp)
                        .width(60.dp), colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                    ),
                    border = BorderStroke(width = 1.dp, color = Color(0xFF7B58FE))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logo_apple),
                        contentDescription = "Facebook",
                        tint = Color.Black,
                        modifier = Modifier.size(50.dp)
                    )
                }
                OutlinedButton(
                    onClick = { }, modifier = Modifier
                        .height(30.dp)
                        .width(67.dp), colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                    ),
                    border = BorderStroke(width = 1.dp, color = Color(0xFF7B58FE))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logo_google),
                        contentDescription = "Facebook",
                        tint = Color.Black,
                        modifier = Modifier.size(40.dp)
                    )
                }
                OutlinedButton(
                    onClick = { }, modifier = Modifier
                        .height(30.dp)
                        .width(67.dp), colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                    ),
                    border = BorderStroke(width = 1.dp, color = Color(0xFF7B58FE))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logo_fb),
                        contentDescription = "Facebook",
                        tint = Color.Black,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            ClickableText(
                text = AnnotatedString("Don't have account? Sign Up"),
                onClick = { },
                style = LocalTextStyle.current.copy(color = Color.White)
            )
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    AppFitPlanMobileTheme {
        LoginScreen(navController = rememberNavController())
    }
}