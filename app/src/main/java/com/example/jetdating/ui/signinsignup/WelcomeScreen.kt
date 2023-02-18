package com.example.jetdating.ui.signinsignup

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetdating.R
import com.example.jetdating.ui.theme.JetDatingTheme
import com.example.jetdating.ui.theme.stronglyDeemphasizedAlpha
import com.example.jetdating.ui.util.supportWideScreen

@Composable
fun WelcomeScreen(
    onSignInGoogle: () -> Unit,
    onSignInNaver: () -> Unit,
    onSignInPhoneNumber: () -> Unit,
    onProblemSignIn: () -> Unit,
) {
    Surface(modifier = Modifier.supportWideScreen()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(
                modifier = Modifier.weight(1f)
            )
            Branding()

            Spacer(
                modifier = Modifier.weight(1f)
            )

            SignInCreateAccount(
                onSignInGoogle = onSignInGoogle,
                onSignInNaver = onSignInNaver,
                onSignInPhoneNumber = onSignInPhoneNumber,
                onProblemSignIn = onProblemSignIn,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
        }
    }
}

@Composable
private fun Branding(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.wrapContentHeight(align = Alignment.CenterVertically)
    ) {
        Logo(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 76.dp)
        )
        Text(
            text = stringResource(id = R.string.app_tagline),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
private fun Logo(
    modifier: Modifier = Modifier,
    lightTheme: Boolean = LocalContentColor.current.luminance() < 0.5f,
) {
    val assetId = if (lightTheme) {
        R.drawable.ic_launcher_foreground
    } else {
        R.drawable.ic_launcher_foreground
    }
    Image(
        painter = painterResource(id = assetId),
        modifier = modifier,
        contentDescription = null
    )
}

@Composable
private fun SignInCreateAccount(
    onSignInGoogle: () -> Unit,
    onSignInNaver: () -> Unit,
    onSignInPhoneNumber: () -> Unit,
    onProblemSignIn: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = stringResource(id = R.string.terms_and_conditions),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = stronglyDeemphasizedAlpha),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 72.dp, bottom = 8.dp, start = 12.dp, end = 12.dp)
        )
        SignInButton(
            logo = R.drawable.ic_google_logo,
            text = stringResource(id = R.string.sign_in_google),
            contentDescription = "Sign In with Google",
            onClick = onSignInGoogle,
            modifier = Modifier
                .fillMaxWidth()
        )
        SignInButton(
//            logo = R.drawable.ic_google_logo,
            text = stringResource(id = R.string.sign_in_naver),
            contentDescription = "Sign In with Naver",
            onClick = onSignInNaver,
            modifier = Modifier
                .fillMaxWidth()
        )
        SignInButton(
            text = stringResource(id = R.string.sign_in_phone_number),
            contentDescription = "Sign In with phone number",
            onClick = onSignInPhoneNumber,
            modifier = Modifier
                .fillMaxWidth()
        )
        TextButton(onClick = onProblemSignIn, modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)) {
            Text(
                text = stringResource(id = R.string.problem_with_sign_in),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,

            )
        }
    }
}

@Composable
private fun SignInButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes logo: Int? = null,
    text: String,
    contentDescription: String = "",
    colors: ButtonColors = ButtonDefaults.buttonColors()
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = colors,
    ) {
        logo?.let {
            Icon(
                painter = painterResource(logo),
                contentDescription = contentDescription,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = text,
        )
    }
}

@Preview(name = "Welcome light theme", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Welcome dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomeScreenPreview() {
    JetDatingTheme() {
        WelcomeScreen(
            onSignInGoogle = {},
            onSignInNaver = {},
            onSignInPhoneNumber = {},
            onProblemSignIn = {})
    }
}