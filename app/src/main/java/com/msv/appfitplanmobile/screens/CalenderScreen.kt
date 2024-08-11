package com.msv.appfitplanmobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.navigation.BottomNavigationBarScreen

@Composable
fun CalenderScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBarScreen(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF3C3C3C))
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            HistorySection(navController)
            WeightSection(navController)
            HeightSection(navController)
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun HistorySection(navController: NavController) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("History", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            TextButton(
                onClick = {
                    navController.navigate("all_notes")
                },
                colors = ButtonDefaults.textButtonColors(contentColor = Color.White)
            ) {
                Text(
                    "All Notes",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF5F33FF)
            ),
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("M", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text("T", color = Color.White, fontSize = 16.sp)
                    Text("W", color = Color.White, fontSize = 16.sp)
                    Text("T", color = Color.White, fontSize = 16.sp)
                    Text("F", color = Color.White, fontSize = 16.sp)
                    Text("S", color = Color.White, fontSize = 16.sp)
                    Text("S", color = Color.White, fontSize = 16.sp)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("19", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text("20", color = Color.White, fontSize = 16.sp)
                    Text("21", color = Color.White, fontSize = 16.sp)
                    Text("22", color = Color.White, fontSize = 16.sp)
                    Text("23", color = Color.White, fontSize = 16.sp)
                    Text("24", color = Color.White, fontSize = 16.sp)
                    Text("25", color = Color.White, fontSize = 16.sp)
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Text("🔥 0 Day Streak", color = Color.White, fontSize = 14.sp)
            }
            Row {
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text("Best Streak ", color = Color.White, fontSize = 14.sp)
                    Text(
                        "93 Day",
                        color = Color.White,
                        fontSize = 14.sp,
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}

@Composable
fun WeightSection(navController: NavController) {
    SectionCard(title = "Weight") {
        var firstHeight by remember { mutableStateOf("160") }
        var recentHeight by remember { mutableStateOf("165") }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Color.White, RoundedCornerShape(10.dp))
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("First Height:", fontSize = 16.sp)
                    Text("$firstHeight Kg", fontSize = 16.sp, color = Color.Black)
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .background(Color.White, RoundedCornerShape(10.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Recent Height:", fontSize = 16.sp)
                    Text("$recentHeight Kg", fontSize = 16.sp, color = Color.Black)
                }
            }

            Button(
                onClick = {
                          navController.navigate("body_sample")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally)
                    .width(120.dp)
            ) {
                Text("Add Weight")
            }
        }
    }
}

@Composable
fun HeightSection(navController: NavController) {
    SectionCard(title = "Height") {
        var firstHeight by remember { mutableStateOf("160") }
        var recentHeight by remember { mutableStateOf("165") }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Color.White, RoundedCornerShape(10.dp))
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("First Height:", fontSize = 16.sp)
                    Text("$firstHeight Cm", fontSize = 16.sp, color = Color.Black)
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .background(Color.White, RoundedCornerShape(10.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Recent Height:", fontSize = 16.sp)
                    Text("$recentHeight Cm", fontSize = 16.sp, color = Color.Black)
                }
            }

            Button(
                onClick = {
                          navController.navigate("body_sample")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally) 
                    .width(120.dp)
            ) {
                Text("Add Height")
            }
        }
    }
}

@Composable
fun SectionCard(title: String, content: @Composable () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF5F33FF)
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(title, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            content()
        }
    }
}

@Composable
fun InputField(label: String, onValueChange: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(label, color = Color.White, fontSize = 16.sp)
        TextField(
            value = "",
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 8.dp),
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 16.sp
            )
        )
    }
}


@Preview
@Composable
fun CalenderScreenPreview() {
    CalenderScreen(navController = rememberNavController())
}
