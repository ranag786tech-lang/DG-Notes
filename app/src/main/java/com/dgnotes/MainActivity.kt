package com.dgnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dgnotes.app.navigation.AppNavGraph
import com.dgnotes.app.viewmodel.NotesViewModel
import com.dgnotes.app.viewmodel.NotesViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val notesViewModel: NotesViewModel = viewModel(factory = NotesViewModelFactory)
            AppNavGraph(viewModel = notesViewModel)
        }
    }
}
