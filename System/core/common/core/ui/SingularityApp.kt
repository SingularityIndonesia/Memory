/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package core.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import core.Platform
import core.Preference
import core.StateSaver
import core.SystemLogger
import core.adt.UnknownPlatform
import core.model.dummy.DummyPreference
import core.model.dummy.DummySystemLogger
import core.ui.designsystem.atom.SSurface
import core.ui.designsystem.boson.SingularityTheme

@Composable
fun SingularityApp(content: @Composable () -> Unit) {
    SingularityTheme {
        SSurface(
            modifier = Modifier.fillMaxSize(),
        ) {
            content()
        }
    }
}
