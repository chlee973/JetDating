package com.example.jetdating.ui.getuserinfo

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetdating.R
import com.example.jetdating.ui.signinsignup.WelcomeScreen
import com.example.jetdating.ui.theme.JetDatingTheme
import com.example.jetdating.ui.theme.slightlyDeemphasizedAlpha
import com.example.jetdating.ui.theme.stronglyDeemphasizedAlpha
import com.example.jetdating.ui.util.supportWideScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetUserInfoScreen(
    getUserInfoScreenData: GetUserInfoScreenData,
    isContinueEnabled: Boolean,
    onContinuePressed: () -> Unit,
    onPreviousPressed: () -> Unit,
    onPassPressed: () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
){
    Surface(modifier = Modifier.supportWideScreen()) {
        Scaffold(
            topBar = {
                GetUserInfoTopAppBar(
                    questionIndex = getUserInfoScreenData.questionIndex,
                    totalQuestionsCount = getUserInfoScreenData.questionCount,
                    onPreviousPressed = onPreviousPressed,
                    doesExistsPassButton = getUserInfoScreenData.doesExistsPassButton,
                    onPassPressed = onPassPressed
                )
            },
            content = content,
            bottomBar = {
                GetUserInfoBottomBar(
                    isContinueEnabled = isContinueEnabled,
                    onContinuePressed = onContinuePressed
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgreeRuleScreen(
    onAgreePressed: () -> Unit
) {
    Surface(modifier = Modifier.supportWideScreen()) {
        Scaffold(
            content = { innerPadding ->
                val modifier = Modifier.padding(innerPadding)
            },
            bottomBar = {
                Button(
                    onClick = onAgreePressed,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 24.dp)
                ) {
                    Text(text = stringResource(id = R.string.agree))
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class) // CenterAlignedTopAppBar is experimental in m3
@Composable
fun GetUserInfoTopAppBar(
    questionIndex: Int,
    totalQuestionsCount: Int,
    onPreviousPressed: () -> Unit,
    doesExistsPassButton: Boolean,
    onPassPressed: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {

        val animatedProgress by animateFloatAsState(
            targetValue = (questionIndex + 1) / totalQuestionsCount.toFloat(),
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )
        LinearProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier
                .fillMaxWidth(),
            trackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
        )

        CenterAlignedTopAppBar(
            title = {},
            navigationIcon = {
                IconButton(
                    onClick = onPreviousPressed,
                    modifier = Modifier.padding(4.dp)
                ) {
                    Icon(
                        Icons.Filled.ArrowBackIos,
                        contentDescription = stringResource(id = R.string.close),
                        tint = MaterialTheme.colorScheme.onSurface.copy(stronglyDeemphasizedAlpha)
                    )
                }
            },
            actions = {
                if(doesExistsPassButton) {
                    TextButton(onClick = onPassPressed) {
                        Text(
                            text = stringResource(id = R.string.pass),
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = slightlyDeemphasizedAlpha),
                            style = MaterialTheme.typography.titleMedium,
                        )
                    }
                }
            }
        )


    }
}

@Composable
fun GetUserInfoBottomBar(
    isContinueEnabled: Boolean,
    onContinuePressed: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 20.dp)
    ) {

        Button(
            modifier = Modifier
                .height(48.dp),
            onClick = onContinuePressed,
            enabled = isContinueEnabled,
        ) {
            Text(
                text = stringResource(id = R.string.user_continue),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }

}

@Preview(name = "Welcome light theme", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Welcome dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GetUserInfoScreenPreview() {
    JetDatingTheme() {
        GetUserInfoScreen(
            getUserInfoScreenData = GetUserInfoScreenData(1, 3, true, UserInfoQuestion.COMPANY),
            isContinueEnabled = true,
            onContinuePressed = {},
            onPreviousPressed = {},
            onPassPressed = {}
        ){

        }
    }
}
