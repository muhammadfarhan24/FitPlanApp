package com.msv.appfitplanmobile.screens.note_sample

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.msv.appfitplanmobile.data.local.room.entity.Note

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NoteSampleScreen(navController: NavController) {
    val viewModel: NoteViewModel = hiltViewModel()

    var note by remember {
        mutableStateOf("")
    }
    var date by remember {
        mutableStateOf("")
    }

    AlertDialog(
        onDismissRequest = { },
        title = {
            Text(text = "Add Note")
        },
        text = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                TextField(
                    value = note,
                    onValueChange = { note = it },
                    label = { Text(text = "Note") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = date,
                    onValueChange = { date = it },
                    label = { Text(text = "Date") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    viewModel.setNote(Note(date, note))
                    note = ""
                    date = ""
                    navController.popBackStack()
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Save")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Cancel")
            }
        }
    )
}
