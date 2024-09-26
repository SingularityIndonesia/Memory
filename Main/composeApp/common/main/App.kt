/*
 * Copyright (c) 2024 Singularity Indonesia
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import core.Platform
import core.adt.IOSPlatform
import main.protocol.AttributeBasedAccessControl
import main.protocol.AuthenticationProtocol
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    val topPadding =
        WindowInsets.safeDrawing
            .asPaddingValues()
            .calculateTopPadding()
            .let {
                when (Platform.current) {
                    is IOSPlatform -> it.minus(8.dp)
                    else -> it
                }
            }

    Box(
        modifier =
            Modifier
                .padding(top = topPadding)
                .imePadding(),
    ) {
        AuthenticationProtocol {
            AttributeBasedAccessControl {
                Feature(
                    navController = navController,
                )
            }
        }
    }
}
