/*
 * Copyright (c) 2024 Singularity Indonesia (stefanus.ayudha@gmail.com)
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.mmk.kmpauth.google.GoogleAuthCredentials
import com.mmk.kmpauth.google.GoogleAuthProvider
import main.pane.login.LoginPane
import common.StateSaver
import common.getPlatform
import common.isIOS
import core.ui.SingularityApp
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.initialize
import main.pane.login.LoginPaneViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    val stateSaver = remember { StateSaver() }
    val context = remember { MainContext() }
    val viewModel: LoginPaneViewModel = viewModel()

    LaunchedEffect(Unit) {
        /*Firebase.initialize(
            context = , //Fixme need context
            options = FirebaseOptions(
                applicationId = "1:990511351674:android:9cc5989bfb7eccecb1f8c3",
                projectId = "memories-434910",
                apiKey = "AIzaSyCXBoD0QBeBk5MymcGQ1mba36RYgNbYdC8",
            )
        )*/
        GoogleAuthProvider
            .create(
                GoogleAuthCredentials(
                    serverId = "990511351674-r9hcva95htr8upshhaqo838sl1mcvvns.apps.googleusercontent.com"
                )
            )
        viewModel.doLogin() // GoogleAuthProvider should ready before sign in with google was invoked
    }

    val topPadding =
        WindowInsets.safeDrawing
            .asPaddingValues()
            .calculateTopPadding()
            .let {
                if (getPlatform().isIOS()) {
                    it.minus(8.dp)
                } else {
                    it.minus(0.dp)
                }
            }

    SingularityApp {
        Box(
            modifier =
                Modifier
                    .padding(top = topPadding)
                    .imePadding(),
        ) {
            /*with(context) {
                MainNavigation(
                    navController = navController,
                    stateSaver = stateSaver,
                )
            }*/

            /*LoginPane()*/
            LoginPane(viewModel = viewModel)
        }
    }
}
