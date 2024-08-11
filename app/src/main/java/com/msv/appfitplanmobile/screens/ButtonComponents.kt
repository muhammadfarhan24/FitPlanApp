package com.msv.appfitplanmobile.screens

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun LoginSignupButton(
    buttonClicked: () -> Unit = {},
    buttonText: String = "Login",
    buttonBackground: Color = Color.White,
    buttonTextColor: Color = Color.Black,
) {
    Button(
        onClick = { buttonClicked() },
        modifier = Modifier
            .height(52.dp)
            .width(276.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonBackground
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = buttonText,
            fontSize = 22.sp,
            color = buttonTextColor,
            fontWeight = FontWeight.Bold
        )
    }
}