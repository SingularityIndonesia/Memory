/*
 * Copyright (c) 2024 Singularity Indonesia (stefanus.ayudha@gmail.com)
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package core.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.ui.designsystem.SingularityTheme
import core.ui.designsystem.component.SSurface

@Composable
fun SingularityApp(
    singularityScope: SingularityScope = SingularityScope(),
    content: @Composable SingularityScope.() -> Unit,
) {
    singularityScope.SingularityScopeCompose {
        SingularityTheme {
            SSurface(
                modifier = Modifier.fillMaxSize(),
            ) {
                content()
            }
        }
    }
}
