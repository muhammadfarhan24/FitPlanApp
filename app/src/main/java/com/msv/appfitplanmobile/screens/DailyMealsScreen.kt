package com.msv.appfitplanmobile.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.ui.theme.AppFitPlanMobileTheme
import com.msv.appfitplanmobile.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyMealsScreen(navController: NavController) {
    Scaffold(
        bottomBar = { }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF3C3C3C))
                .padding(innerPadding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { navController.popBackStack() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back1),
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Daily Meals",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically)
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                val days = listOf(
                    "Monday", "Tuesday", "Wednesday",
                    "Thursday", "Friday", "Saturday"
                )
                val mealImageRes = listOf(
                    R.drawable.meal_monday,
                    R.drawable.meal_tuesday,
                    R.drawable.meal_wednesday,
                    R.drawable.meal_thursday,
                    R.drawable.meal_friday,
                    R.drawable.meal_saturday
                )

                itemsIndexed(days) { index, day ->
                    MealCard(day = day, imageRes = mealImageRes[index])
                }
            }
        }
    }
}

@Composable
fun MealCard(day: String, imageRes: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = day,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 4.dp, top = 2.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFF5F33FF))
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "$day Meal Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(10.dp))
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(text = "Breakfast: Fruit Salad", color = Color.White)
                    Text(text = "Lunch: Carbohydrate", color = Color.White)
                    Text(text = "Dinner: Oat Meal", color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDailyMealsScreen() {
    AppFitPlanMobileTheme {
        DailyMealsScreen(navController = rememberNavController())
    }
}
