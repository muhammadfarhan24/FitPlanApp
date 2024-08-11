package com.msv.appfitplanmobile.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.R
import com.msv.appfitplanmobile.navigation.BottomNavigationBarScreen
import com.msv.appfitplanmobile.ui.theme.AppFitPlanMobileTheme

@Composable
fun HomeScreen(navController: NavController) {
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
            TopBar(navController)
            WeeklyTarget()
            Spacer(modifier = Modifier.height(16.dp))
            RecommendationsAndTarget()
            Spacer(modifier = Modifier.height(16.dp))
            PopularTraining()
        }
    }
}

@Composable
fun TopBar(navController: NavController) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "FitPlan",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF7B58FE)
        )
        IconButton(
            onClick = { navController.navigate("notifications") },
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF5F33FF))
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    tint = Color.White,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

@Composable
fun WeeklyTarget() {
    val days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = "Weekly Target",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF5F33FF))
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    for (i in 10..15) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = days[i - 10],
                                color = Color.White,
                                fontSize = 12.sp
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(Color.White)
                            ) {
                                if (i < 12) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = "Check",
                                        tint = Color(0xFF75F33FF),
                                        modifier = Modifier
                                            .align(Alignment.Center)
                                            .size(30.dp)
                                    )
                                } else {
                                    Text(
                                        text = i.toString(),
                                        color = Color(0xFF75F33FF),
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.align(Alignment.Center)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RecommendationsAndTarget() {
    Column {
        Text(
            "Recommendation & Target",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            RecomendationAndTargetCard("Superset", 12, R.drawable.superset)
            RecomendationAndTargetCard("Proset", 5, R.drawable.proset)
        }
    }
}

@Composable
fun RecomendationAndTargetCard(title: String, count: Int, imageRes: Int) {
    Card(
        modifier = Modifier
            .width(170.dp)
            .height(120.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            ) {
                Text(title, color = Color.White, fontWeight = FontWeight.Bold)
                Text("$count Training", color = Color.White)
            }
        }
    }
}

@Composable
fun PopularTraining() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Popular Training",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "See more",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.padding(end = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        TrainingCard("Build wider shoulder", "8 min | Beginner", R.drawable.shoulder_workout)
        Spacer(modifier = Modifier.height(8.dp))
        TrainingCard("Ripped V-cut abs", "17 min | Advance", R.drawable.abs_workout)
        Spacer(modifier = Modifier.height(8.dp))
        TrainingCard("Belly fat burner", "12 min | Intermediate", R.drawable.belly_workout)
    }
}

@Composable
fun TrainingCard(title: String, subtitle: String, imageRes: Int, backgroundColor: Color = Color(0xFF5F33FF)) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight()
            ) {
                Text(title, color = Color.White, fontWeight = FontWeight.Bold)
                Text(subtitle, color = Color(0xFFF5F5F5))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    AppFitPlanMobileTheme {
        HomeScreen(navController = rememberNavController())
    }
}
