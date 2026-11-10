package com.abhijeet.todoApp.ui.screens.homescreen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.abhijeet.todoApp.ui.screens.TodoBackgroundScreen
import com.abhijeet.todoApp.ui.screens.homescreen.components.HomePageContent

@Composable
fun HomeScreen(onNavigateToTaskScreen: () -> Unit) {
    Scaffold {
        TodoBackgroundScreen {
            HomePageContent(onNavigateToTaskScreen)
        }
    }
}