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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import common.StateSaver
import common.getPlatform
import common.isIOS
import core.ui.SingularityApp
import core.ui.SingularityScope
import main.protocol.AttributeBasedAccessControl
import main.protocol.AuthenticationProtocol
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val singularityScope = remember { SingularityScope() }
    val navController = rememberNavController()
    val stateSaver = remember { StateSaver() }

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

    SingularityApp(singularityScope = singularityScope) {
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
                        stateSaver = stateSaver,
                    )
                }
            }
        }
    }
}
