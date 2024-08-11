package com.msv.appfitplanmobile.screens.boarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.R
import com.msv.appfitplanmobile.screens.login.LoginScreen
import com.msv.appfitplanmobile.screens.LoginSignupButton

@Composable
fun BoardingScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.8f))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.background),
                    contentScale = ContentScale.FillBounds
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LoginSignupButton(
                buttonClicked = {
                    navController.navigate("login")
                },
                buttonText = "Login",
                buttonBackground = Color.White,
                buttonTextColor = Color(0xFF7B58FE)
            )
            Spacer(modifier = Modifier.height(10.dp))
            LoginSignupButton(
                buttonText = "Sign Up",
                buttonBackground = Color(0xFF7B58FE),
                buttonTextColor = Color.White
            )
        }

    }

}
@Preview
@Composable
private fun PrevLog() {
    LoginScreen(navController = rememberNavController())
}