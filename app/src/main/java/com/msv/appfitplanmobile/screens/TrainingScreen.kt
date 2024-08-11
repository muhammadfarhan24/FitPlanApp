package com.msv.appfitplanmobile.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.ui.theme.AppFitPlanMobileTheme
import com.msv.appfitplanmobile.R
import com.msv.appfitplanmobile.navigation.BottomNavigationBarScreen

@Composable
fun TrainingScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBarScreen(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFF3C3C3C))
        ) {
            TrainingRecommendations(navController)
            DailyMeals(navController)
            Trivia(navController)
        }
    }
}

@Composable
fun TrainingRecommendations(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextButton(
            onClick = {
                navController.navigate("training_recommendation")
            },
            colors = ButtonDefaults.textButtonColors(contentColor = Color.White)
        ) {
            Text(
                text = "Training Recommendations",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = R.drawable.dumbbell),
            contentDescription = "Training Recommendations",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    navController.navigate("training_recommendation")
                }
        )
    }
}

@Composable
fun DailyMeals(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Daily Meals",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { navController.navigate("daily_meals") }
            )
            Text(
                text = "See other",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.clickable { navController.navigate("daily_meals") }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF5F33FF), RoundedCornerShape(8.dp))
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(verticalArrangement = Arrangement.Top) {
                Text(
                    text = "Friday",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(id = R.drawable.friday),
                    contentDescription = "Daily Meals",
                    modifier = Modifier
                        .size(72.dp, 48.dp)
                        .padding(bottom = 4.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            DailyMealItem("Fruit Salad", R.drawable.meteoconsunset, paddingValue = 4.dp)
            DailyMealItem("Potato Mesh", R.drawable.sunbold, paddingValue = 4.dp)
            DailyMealItem("Oat Meal + Milk", R.drawable.clear_night, paddingValue = 4.dp)
        }
    }
}

@Composable
fun DailyMealItem(meal: String, iconRes: Int, paddingValue: Dp = 8.dp) {
    Box(
        modifier = Modifier
            .background(Color(0xFFAF99FF), RoundedCornerShape(8.dp))
            .padding(paddingValue)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = "Icon",
                modifier = Modifier
                    .size(24.dp)
                    .padding(bottom = 4.dp)
            )
            Text(
                text = meal,
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}


@Composable
fun Trivia(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Trivia",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { navController.navigate("trivia") }
            )
            Text(
                text = "See other",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.clickable { navController.navigate("trivia") }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TriviaCard(
                imageRes = R.drawable.sleep,
                title = "How to fall asleep in a minute"
            )
            TriviaCard(
                imageRes = R.drawable.diet,
                title = "Maintain a healthy diet to increase body endurance"
            )
            TriviaCard(
                imageRes = R.drawable.exercise,
                title = "Regular exercise to reduce weight"
            )
        }
    }
}

@Composable
fun TriviaCard(imageRes: Int, title: String) {
    Column(
        modifier = Modifier
            .width(110.dp)
            .background(Color(0xFF5F33FF), RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { /* Handle click */ }
        )
        Text(
            text = title,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(horizontal = 4.dp, vertical = 4.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SelfGuideRecommendationScreen() {
    AppFitPlanMobileTheme {
        TrainingScreen(navController = rememberNavController())
    }
}
