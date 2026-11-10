package com.abhijeet


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.abhijeet.todoApp.data.local.ThemeRepository
import com.abhijeet.todoApp.ui.screens.MainScreen
import com.abhijeet.todoApp.ui.theme.TodoAppTheme
import org.koin.compose.koinInject

@Composable
fun App() {
    val themeRepository: ThemeRepository = koinInject()
    val isDarkMode by themeRepository.isDarkMode.collectAsState(initial = null)

    // Default to light theme when no preference is stored (fresh install / Auto).
    val resolvedDarkMode = isDarkMode ?: false

    TodoAppTheme(darkTheme = resolvedDarkMode) {
        MainScreen()
    }
}