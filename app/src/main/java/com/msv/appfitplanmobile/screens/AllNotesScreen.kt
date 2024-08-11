package com.msv.appfitplanmobile.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.R
import com.msv.appfitplanmobile.screens.note_sample.NoteViewModel
import com.msv.appfitplanmobile.ui.theme.AppFitPlanMobileTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllNotesScreen(
    navController: NavController = rememberNavController(),
    viewModel: NoteViewModel = hiltViewModel()
    ){
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                                           navController.navigate("note_sample")
            }, containerColor = Color(0xFF5F33FF)) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF3C3C3C))
                .padding(paddingValues)
        ) {
            TopAppBar(
                title = { Text("Training Calendar", color = Color.White, fontSize = 28.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        val backIcon: Painter = painterResource(id = R.drawable.back1)
                        Image(
                            painter = backIcon,
                            contentDescription = "Back",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF3C3C3C)
                )
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text("History", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* Handle previous month action */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.vectorleft),
                            contentDescription = "Previous month",
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("May", color = Color.White, fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = { /* Handle next month action */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.vectorright),
                            contentDescription = "Next month",
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
                CalendarSection()
                Box(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .weight(1f)
                ) {
                    NotesSection(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun CalendarSection() {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("M", color = Color.White, fontSize = 16.sp)
            Text("T", color = Color.White, fontSize = 16.sp)
            Text("W", color = Color.White, fontSize = 16.sp)
            Text("T", color = Color.White, fontSize = 16.sp)
            Text("F", color = Color.White, fontSize = 16.sp)
            Text("S", color = Color.White, fontSize = 16.sp)
            Text("S", color = Color.White, fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))

        val daysInMonth = (1..31).toList()
        val emptyDaysBeforeStart = 3

        val weeks = (List(emptyDaysBeforeStart) { "" } + daysInMonth).chunked(7)

        weeks.forEach { week ->
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                week.forEach { day ->
                    if (day is String) {
                        Spacer(modifier = Modifier.size(40.dp))
                    } else {
                        DateBox(day.toString(), isActive = day == 3 || day == 5 || day == 10 || day == 11)
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun DateBox(date: String, isActive: Boolean = false) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(
                if (isActive) Color(0xFFAF99FF) else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(date, color = Color.White)
    }
}

@Composable
fun NotesSection(viewModel: NoteViewModel) {
    val listNote by viewModel.listNote.collectAsState() 

    Column(modifier = Modifier.padding(top = 16.dp)) {
        Text("Notes", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        listNote.forEach { note ->
            NoteCard(date = note.date, note = note.note)
        }
    }
}

@Composable
fun NoteCard(date: String, note: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(date, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(note, style = MaterialTheme.typography.titleSmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalendarScreenPreview() {
    AppFitPlanMobileTheme {
        AllNotesScreen()
    }
}
