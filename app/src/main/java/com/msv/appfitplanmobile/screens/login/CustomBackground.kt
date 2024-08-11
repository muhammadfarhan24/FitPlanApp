package com.msv.appfitplanmobile.screens.login

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill

@Composable
fun CustomBackground() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val path = Path().apply {
            moveTo(0f, size.height * 0.3f)
            lineTo(size.width, size.height * 0.15f)
            lineTo(size.width, 0f)
            lineTo(0f, 0f)
            close()
        }
        drawPath(
            path = path,
            color = Color(0xFF7B58FE),
            style = Fill
        )
    }
}