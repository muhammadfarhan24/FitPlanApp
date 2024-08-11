package com.msv.appfitplanmobile.halaman_pilih

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.ui.theme.AppFitPlanMobileTheme
import kotlinx.coroutines.delay

@Composable
fun SuccessScreen(navController: NavController) {

    LaunchedEffect(key1 = Unit) {
        delay(2000)
        navController.navigate("home")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3C3C3C)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = Color(0xFF885EF9),
                modifier = Modifier
                    .size(128.dp)
                    .background(Color(0xFF3C3C3C))
            )
            Text(
                text = "Success!",
                color = Color(0xFF885EF9),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuccesPreview() {
    AppFitPlanMobileTheme {
        SuccessScreen(navController = rememberNavController())
    }
}
