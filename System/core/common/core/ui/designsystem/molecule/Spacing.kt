/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package core.ui.designsystem.molecule

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.ui.designsystem.atom.SingularityTheme
import core.ui.designsystem.atom.`extra-large-spacing`
import core.ui.designsystem.atom.`large-spacing`
import core.ui.designsystem.atom.`medium-spacing`
import core.ui.designsystem.atom.`paragraph-spacing`
import core.ui.designsystem.atom.`small-spacing`

@Composable
fun SSmallSpacing() {
    val attr = SingularityTheme.attr
    Spacer(
        modifier = Modifier.size(attr.`small-spacing`),
    )
}

@Composable
fun SMediumSpacing() {
    val attr = SingularityTheme.attr
    Spacer(
        modifier = Modifier.size(attr.`medium-spacing`),
    )
}

@Composable
fun SLargeSpacing() {
    val attr = SingularityTheme.attr
    Spacer(
        modifier = Modifier.size(attr.`large-spacing`),
    )
}

@Composable
fun SExtraLargeSpacing() {
    val attr = SingularityTheme.attr
    Spacer(
        modifier = Modifier.size(attr.`extra-large-spacing`),
    )
}

@Composable
fun SParagraphSpacing() {
    val attr = SingularityTheme.attr
    Spacer(
        modifier = Modifier.size(attr.`paragraph-spacing`),
    )
}

@Composable
fun ColumnScope.Expand() {
    Spacer(
        modifier = Modifier.weight(1f),
    )
}

@Composable
fun RowScope.Expand() {
    Spacer(
        modifier = Modifier.weight(1f),
    )
}
