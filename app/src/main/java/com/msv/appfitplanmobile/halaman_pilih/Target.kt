package com.msv.appfitplanmobile.halaman_pilih

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
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

@Composable
fun MainTargetScreen(navController: NavController) {
    var selectedTarget by remember { mutableStateOf<String?>(null) }

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
                progress = 0.6f,
                color = Color(0xFF5F33FF),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
                    .clip(RoundedCornerShape(9.dp))
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "What is your main target?",
                fontSize = 24.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            // Target options
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                TargetOption(
                    imageRes = R.drawable.target,
                    text = "Lose Weight",
                    isSelected = selectedTarget == "Lose Weight",
                    onClick = { selectedTarget = "Lose Weight" }
                )
                Spacer(modifier = Modifier.height(20.dp))
                TargetOption(
                    imageRes = R.drawable.target,
                    text = "Gain Muscle",
                    isSelected = selectedTarget == "Gain Muscle",
                    onClick = { selectedTarget = "Gain Muscle" }
                )
                Spacer(modifier = Modifier.height(20.dp))
                TargetOption(
                    imageRes = R.drawable.target,
                    text = "Stay Fit",
                    isSelected = selectedTarget == "Stay Fit",
                    onClick = { selectedTarget = "Stay Fit" }
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { navController.navigate("next") },
                enabled = selectedTarget != null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .height(40.dp)
                    .width(260.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF7B58FE)
                ), shape = RoundedCornerShape(8.dp)
            ) {
                Text("Next", color = Color.White)
            }

        }
    }
}

@Composable
fun TargetOption(imageRes: Int, text: String, isSelected: Boolean, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFF7B58FE) else Color.Gray
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.large)
                    .size(80.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = text,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainTargetScreenPreview() {
    MainTargetScreen(navController = rememberNavController())
}
