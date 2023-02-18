package com.example.jetdating.ui.signinsignup

import androidx.compose.runtime.Composable

@Composable
fun WelcomeRoute(
    onNavigateToSignInPhoneNumber: () -> Unit,
    onNavigateToProblemSignIn: () -> Unit
) {
    WelcomeScreen(
        onSignInGoogle = { /*TODO*/ },
        onSignInNaver = { /*TODO*/ },
        onSignInPhoneNumber = { /*TODO*/ },
        onProblemSignIn = { /*TODO */}
    )
}