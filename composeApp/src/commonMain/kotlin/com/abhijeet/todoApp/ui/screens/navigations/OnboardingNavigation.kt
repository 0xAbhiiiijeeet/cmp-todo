package com.abhijeet.todoApp.ui.screens.navigations

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.runtime.NavKey
import com.abhijeet.todoApp.ui.route.NavRoute
import com.abhijeet.todoApp.ui.screens.OnboardingScreen

/**
 * Onboarding Navigation Graph
 * Handles all onboarding related screens
 */
@Composable
fun OnboardingNavigation(
    onOnboardingComplete: () -> Unit
) {
    val navigationState = rememberNavigationState(
        startRoute = NavRoute.Onboarding,
        topLevelRoutes = listOf(NavRoute.Onboarding)
    )
    val navigator = remember { Navigator(navigationState) }

    val entryProvider = entryProvider<NavKey> {
        entry<NavRoute.Onboarding> {
            OnboardingScreen(
                onOnboardingComplete = onOnboardingComplete
            )
        }
    }

    NavDisplay(
        modifier = Modifier.fillMaxSize(),
        entries = navigationState.toEntries(entryProvider),
        onBack = { navigator.goBack() }
    )
}
