/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable

@Composable
fun SingularityPane(content: @Composable BoxScope.() -> Unit) {
    Box {
        content(this)
    }
}
