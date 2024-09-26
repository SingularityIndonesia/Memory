/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package main

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import core.Platform
import core.Preference
import core.StateSaver
import core.SystemLogger
import core.model.OSPreference
import core.model.SystemLogger
import core.tool.getPlatform
import core.ui.SingularityApp

class MainActivity : ComponentActivity() {
    private val stateSaver = core.model.StateSaver
    private val platform by lazy { getPlatform() }
    private val systemLogger by lazy { SystemLogger() }
    private val preference by lazy { OSPreference(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SetStatusBarColor()
            SingularityApp {
                CompositionLocalProvider(
                    StateSaver provides stateSaver,
                    Platform provides platform,
                    SystemLogger provides systemLogger,
                    Preference provides preference,
                ) {
                    App()
                }
            }
        }
    }

    @Composable
    private fun SetStatusBarColor() {
        val isDarkTheme = isSystemInDarkTheme()

        with(window) {
            statusBarColor = Color.TRANSPARENT

            @Suppress("DEPRECATION")
            val darkDecorView =
                window.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR xor
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

            @Suppress("DEPRECATION")
            val lightDecorView =
                window.decorView.systemUiVisibility xor
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

            decorView.systemUiVisibility =
                if (isDarkTheme) {
                    darkDecorView
                } else {
                    lightDecorView
                }

            WindowCompat.setDecorFitsSystemWindows(
                window,
                false,
            )
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}
