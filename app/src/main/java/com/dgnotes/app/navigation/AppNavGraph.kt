package com.dgnotes.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dgnotes.app.ui.NotesScreen
import com.dgnotes.app.viewmodel.NotesViewModel

@Composable
fun AppNavGraph(viewModel: NotesViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "notes") {
        composable("notes") {
            NotesScreen(viewModel)
        }
    }
}
