package com.msv.appfitplanmobile.halaman_pilih

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LevelSelectionScreen(navController: NavController) {
    var selectedLevel by remember { mutableStateOf<String?>(null) }

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color(0xFF3C3C3C))
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            LinearProgressIndicator(
                progress = 1f,
                color = Color(0xFF6200EE),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
                    .clip(RoundedCornerShape(9.dp))
            )
            Spacer(modifier = Modifier.height(22.dp))
            Text(
                text = "Choose your level!",
                fontSize = 23.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            // Level options
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                LevelOption(
                    level = "Beginner",
                    description = "5-10 minutes / day",
                    isSelected = selectedLevel == "Beginner",
                    onClick = { selectedLevel = "Beginner" }
                )

                LevelOption(
                    level = "Intermediate",
                    description = "15-20 minutes / day",
                    isSelected = selectedLevel == "Intermediate",
                    onClick = { selectedLevel = "Intermediate" }
                )

                LevelOption(
                    level = "Advanced",
                    description = "20-35 minutes / day",
                    isSelected = selectedLevel == "Advanced",
                    onClick = { selectedLevel = "Advanced" }
                )

                LevelOption(
                    level = "Trainer",
                    description = "40 minutes / day",
                    isSelected = selectedLevel == "Trainer",
                    onClick = { selectedLevel = "Trainer" }
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { navController.navigate("finish") },
                enabled = selectedLevel != null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .height(40.dp)
                    .width(260.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF7B58FE)
                ), shape = RoundedCornerShape(8.dp)
            ) {
                Text("Finish", color = Color.White)
            }
        }
    }
}

@Composable
fun LevelOption(level: String, description: String, isSelected: Boolean, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFF7B58FE) else Color(0xFF444444)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(32.dp)
        ) {
            Text(
                text = level,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LevelSelectionScreenPreview() {
    LevelSelectionScreen(navController = rememberNavController())
}
