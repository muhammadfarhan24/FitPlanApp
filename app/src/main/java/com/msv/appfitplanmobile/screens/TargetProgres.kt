package com.msv.appfitplanmobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.msv.appfitplanmobile.ui.theme.AppFitPlanMobileTheme

@Composable
fun TargetProgressScreen(navController: NavController) {
    var selectedTarget by remember { mutableIntStateOf(3) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3C3C3C))
            .padding(top = 64.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Set a target that\nyou want!",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            style = TextStyle(lineHeight = 50.sp),
            modifier = Modifier.padding(bottom = 48.dp)
        )

        TargetSelectionGrid(selectedTarget) { target ->
            selectedTarget = target
        }

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = { navController.navigate("save") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5F33FF)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.size(width = 200.dp, height = 50.dp)
        ) {
            Text(text = "Save", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun TargetSelectionGrid(selectedTarget: Int, onTargetSelected: (Int) -> Unit) {
    val targets = listOf(2, 3, 4, 5, 6, 7)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        for (row in targets.chunked(3)) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                for (target in row) {
                    TargetButton(
                        target = target,
                        isSelected = target == selectedTarget,
                        onClick = { onTargetSelected(target) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun TargetButton(target: Int, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) Color(0xFF5F33FF) else Color(0xFFD9D9D9)
    val textColor = if (isSelected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .width(80.dp)
            .height(40.dp)
            .background(backgroundColor, shape = RoundedCornerShape(2.dp))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(text = target.toString(), color = textColor, fontSize = 24.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun TargetPreview() {
    AppFitPlanMobileTheme {
        TargetProgressScreen(navController = rememberNavController())
    }
}
