package com.msv.appfitplanmobile.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.ui.theme.AppFitPlanMobileTheme
import com.msv.appfitplanmobile.R
import com.msv.appfitplanmobile.navigation.BottomNavigationBarScreen

@Composable
fun PlanScreen(navController: NavController) {
    Scaffold(
        bottomBar = { }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF3C3C3C))
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                val imagePainter: Painter = painterResource(id = R.drawable.loseweightchallange)
                Image(
                    painter = imagePainter,
                    contentDescription = "Plan",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back1),
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { navController.popBackStack() }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Lose Weight Challenge",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            PlanContent()
            Spacer(modifier = Modifier.weight(1f))
            StartButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
            )
        }
    }
}


@Composable
fun PlanContent(modifier: Modifier = Modifier) {
    val exercises = listOf(
        Exercise(R.drawable.jumping_jacks, "Jumping Jacks", "20x"),
        Exercise(R.drawable.burpees, "Burpees", "20x"),
        Exercise(R.drawable.mountain_climbers, "Mountain Climbers", "20x"),
        Exercise(R.drawable.squat_jumps, "Squat Jumps", "20x"),
        Exercise(R.drawable.lunges, "Lunges", "20x"),
        Exercise(R.drawable.plank, "Plank", "20x")
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF3C3C3C))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        exercises.forEach { exercise ->
            ExerciseItem(exercise)
        }
    }
}

@Composable
fun ExerciseItem(exercise: Exercise) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = exercise.imageRes),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = exercise.title, color = Color.White, fontSize = 18.sp)
            Text(text = exercise.reps, color = Color.Gray, fontSize = 14.sp)
        }
    }
}

@Composable
fun StartButton(modifier: Modifier = Modifier) {
    Button(
        onClick = { /* TODO */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5F33FF)),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.size(width = 200.dp, height = 50.dp)
    ) {
        Text(text = "Start", color = Color.White, fontSize = 16.sp)
    }
}

data class Exercise(val imageRes: Int, val title: String, val reps: String)

@Preview(showBackground = true)
@Composable
fun PlanPreview() {
    AppFitPlanMobileTheme {
        PlanScreen(navController = rememberNavController())
    }
}
