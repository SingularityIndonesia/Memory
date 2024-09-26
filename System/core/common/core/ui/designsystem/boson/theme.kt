/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package core.ui.designsystem.boson

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import core.SystemToken

@Composable
fun SingularityTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme =
        remember("$darkTheme") {
            if (darkTheme) {
                MaterialDarkColorSchemeBinder
            } else {
                MaterialLightColorSchemeBinder
            }
        }

    @Suppress("DEPRECATION")
    val systemToken = remember { SystemToken() }

    CompositionLocalProvider(
        SystemToken provides systemToken,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = MaterialTypographyBinder,
            content = content,
        )
    }
}
