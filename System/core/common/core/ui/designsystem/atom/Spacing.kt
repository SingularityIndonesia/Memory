/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package core.ui.designsystem.atom

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.ui.designsystem.boson.SingularityTheme
import core.ui.designsystem.boson.`extra-large-spacing`
import core.ui.designsystem.boson.`large-spacing`
import core.ui.designsystem.boson.`medium-spacing`
import core.ui.designsystem.boson.`paragraph-spacing`
import core.ui.designsystem.boson.`small-spacing`

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
