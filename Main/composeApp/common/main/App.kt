/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import authentication.pane.challange.AuthenticationChallangePane
import core.ui.designsystem.atom.SIconButton
import main.protocol.AuthenticationProtocol
import org.jetbrains.compose.ui.tooling.preview.Preview
import system.designsystem.resources.Res
import system.designsystem.resources.ic_add

@Composable
fun App() {
    val navController = rememberNavController()

    AuthenticationProtocol(
        chalange = { e, onSuccess ->
            AnimatedVisibility(
                visible = true,
                enter = slideInVertically(),
                exit = slideOutVertically(),
                content = {
                    AuthenticationChallangePane(
                        onSuccess = onSuccess,
                    )
                },
            )
        },
    ) {
        Feature(
            navController = navController,
        )
    }
}

@Preview
@Composable
private fun Preview() {
    SIconButton(
        onClick = {},
        iconResource = Res.drawable.ic_add,
    )
}
