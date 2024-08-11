package com.msv.appfitplanmobile.halaman_pilih

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
fun GenderSelectionScreen(navController: NavController) {
    var selectedGender by remember { mutableStateOf<String?>(null) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
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

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(12.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color.Gray)
            ) {
                LinearProgressIndicator(
                    progress = 0.3f,
                    color = Color(0xFF5F33FF),
                    trackColor = Color.Transparent,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp)
                        .clip(RoundedCornerShape(9.dp))
                )
            }

            Spacer(modifier = Modifier.height(64.dp))

            Text(
                text = "What is your gender?",
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Let's us get to know you better",
                fontSize = 18.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(128.dp))
            // Gender Option

            Box(
                modifier = Modifier
                    .padding(horizontal = 36.dp)
                    .fillMaxWidth()
                    .height(200.dp), contentAlignment = Alignment.Center
            ) {
                GenderOption(
                    icon = R.drawable.male,
                    isSelected = selectedGender == "male",
                    onClick = { selectedGender = "male" },
                    modifier = Modifier.align(
                        Alignment.TopStart
                    )
                )
                GenderOption(
                    icon = R.drawable.female,
                    isSelected = selectedGender == "female",
                    onClick = { selectedGender = "female" },
                    modifier = Modifier.align(
                        Alignment.BottomEnd
                    )
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { navController.navigate("target") },
                enabled = selectedGender != null,
                modifier = Modifier
                    .fillMaxWidth()
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
fun GenderOption(
    icon: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .size(100.dp)
            .background(
                color = if (isSelected) Color(0xFF7B58FE) else Color.Gray,
                shape = MaterialTheme.shapes.large
            )
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GenderPreview() {
    GenderSelectionScreen(navController = rememberNavController())
}
