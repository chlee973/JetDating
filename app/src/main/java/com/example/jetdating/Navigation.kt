package com.example.jetdating

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetdating.Destinations.WELCOME_ROUTE
import com.example.jetdating.ui.signinsignup.WelcomeRoute

object Destinations {
    const val WELCOME_ROUTE = "welcome"
}

@Composable
fun JetDatingNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = WELCOME_ROUTE,
    ) {
        composable(WELCOME_ROUTE) {
            WelcomeRoute(
                onNavigateToProblemSignIn = { /* TODO */ },
                onNavigateToSignInPhoneNumber = { /* TODO */ }
            )
        }
    }
}
