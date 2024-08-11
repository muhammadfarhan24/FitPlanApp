package com.msv.appfitplanmobile.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.R
import com.msv.appfitplanmobile.navigation.BottomNavigationBarScreen
import com.msv.appfitplanmobile.ui.theme.AppFitPlanMobileTheme

@Composable
fun AnalyticsScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBarScreen(navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF3C3C3C))
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            TopSection()
            Spacer(modifier = Modifier.height(20.dp))
            Column {
                TargetProgres(navController)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Plan",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .align(Alignment.Start)
                        .clickable { navController.navigate("plan") }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Plan(navController)
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun TopSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF5F33FF), RoundedCornerShape(8.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        StatItem("Tasks", "1")
        StatItem("Kcal", "950")
        StatItem("Time", "19")
    }
}

@Composable
fun StatItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = label, color = Color.White, fontSize = 16.sp)
    }
}

@Composable
fun TargetProgres(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF5F33FF), RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate("target_progres") },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Target", color = Color.White, fontSize = 16.sp)
            Text(text = "2/3", color = Color.White, fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TargetItem(Color(0xFF393939), isChecked = true)
            TargetItemWithIcon(Color.Red)
            TargetItem(Color(0xFF393939), isChecked = true)
            TargetItem(Color(0xFFD9D9D9), isChecked = false)
            TargetItem(Color(0xFFD9D9D9), isChecked = false)
            TargetItem(Color(0xFFD9D9D9), isChecked = false)
            TargetItem(Color(0xFFD9D9D9), isChecked = false)
        }
    }
}

@Composable
fun TargetItemWithIcon(color: Color) {
    Box(
        modifier = Modifier
            .size(35.dp)
            .background(color, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.x),
            contentDescription = "X Icon",
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun TargetItem(color: Color, isChecked: Boolean) {
    Box(
        modifier = Modifier
            .size(35.dp)
            .background(color, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        if (isChecked) {
            Icon(
                painter = painterResource(id = R.drawable.check1),
                contentDescription = "Checked Icon",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun Plan(navController: NavController) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        PlanItemWithText(
            title = "Lose Weight Challenge",
            imageRes = R.drawable.lose_weight,
            navController = navController,
            navigateTo = "plan"
        )
        PlanItemWithText(
            title = "Gain Muscle Challenge",
            imageRes = R.drawable.gain_muscle,
            navController = navController,
            navigateTo = "plan"
        )
    }
}

@Composable
fun PlanItemWithText(title: String, imageRes: Int, navController: NavController, navigateTo: String) {
    Box(
        modifier = Modifier
            .size(160.dp, 150.dp)
            .clickable { navController.navigate(navigateTo) }
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp, bottom = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressPreview() {
    AppFitPlanMobileTheme {
        AnalyticsScreen(navController = rememberNavController())
    }
}
