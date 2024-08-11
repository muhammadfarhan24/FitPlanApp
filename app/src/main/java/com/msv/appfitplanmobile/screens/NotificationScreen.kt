package com.msv.appfitplanmobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.ui.theme.AppFitPlanMobileTheme
import com.msv.appfitplanmobile.R
import com.msv.appfitplanmobile.navigation.BottomNavigationBarScreen

@Composable
fun NotificationScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBarScreen(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF3C3C3C))
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.back1),
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Notification",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Text(
                text = "Today",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            NotificationCard(
                message = "Don't forget to do the daily challenge!🔥",
                timestamp = "11 am",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            NotificationCard(
                message = "Have a great day! Don't forget to start your day with some exercise😎",
                timestamp = "",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Yesterday",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            NotificationCard(
                message = "It must be tiring after a long day, but don't forget to exercise✨",
                timestamp = "",
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}

@Composable
fun NotificationCard(message: String, timestamp: String, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF8766FF)),
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = message,
                color = Color.White,
                fontSize = 14.sp
            )
            if (timestamp.isNotEmpty()) {
                Text(
                    text = timestamp,
                    color = Color.White,
                    fontSize = 12.sp,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationScreenPreview() {
    AppFitPlanMobileTheme {
        NotificationScreen(navController = rememberNavController())
    }
}
