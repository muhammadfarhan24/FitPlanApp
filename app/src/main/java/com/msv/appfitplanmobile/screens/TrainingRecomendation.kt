package com.msv.appfitplanmobile.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.R
import com.msv.appfitplanmobile.ui.theme.AppFitPlanMobileTheme

@Composable
fun TrainingItem(title: String, imageResId: Int, videoUrl: String) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
                context.startActivity(intent)
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = title,
            modifier = Modifier
                .width(310.dp)
                .height(130.dp)
        )
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


@Composable
fun TrainingRecommendationScreen(navController: NavController) {
    Scaffold(
        bottomBar = { }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF333333))
                .padding(innerPadding)
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .clickable { navController.popBackStack() }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back1),
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Training Recommendation",
                    fontSize = 25.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
            ) {
                val trainingItems = listOf(
                    Triple("Leg Beginner", R.drawable.leg_beginner, "https://www.youtube.com/watch?v=nxi3dBw_JBQ"),
                    Triple("Arm Beginner", R.drawable.arm_beginner, "https://www.youtube.com/watch?v=JyV7mUFSpXs"),
                    Triple("Chest Beginner", R.drawable.chest_beginner, "https://www.youtube.com/watch?v=-kJAFNN8t2Y"),
                    Triple("ABS Beginner", R.drawable.abs_beginner, "https://www.youtube.com/watch?v=BR67urvjDbg"),
                    Triple("Leg Intermediate", R.drawable.leg_intermediate, "https://www.youtube.com/watch?v=8g6YovgySLU"),
                    Triple("Arm Intermediate", R.drawable.arm_intermediate, "https://www.youtube.com/watch?v=wwKb-wZCEjs")
                )

                items(trainingItems) { item ->
                    TrainingItem(
                        title = item.first,
                        imageResId = item.second,
                        videoUrl = item.third
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF3C3C3C, showSystemUi = true)
@Composable
fun TrainingRecommendationScreenPreview() {
    AppFitPlanMobileTheme {
        Surface(color = Color(0xFF3C3C3C)) {
            TrainingRecommendationScreen(navController = rememberNavController())
        }
    }
}