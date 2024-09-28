/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import core.Platform
import core.adt.IOSPlatform
import core.ui.SingularityApp
import core.ui.designsystem.atom.SIconButton
import main.protocol.AttributeBasedAccessControl
import main.protocol.AuthenticationProtocol
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import system.designsystem.resources.Res
import system.designsystem.resources.ic_add

@Composable
fun App() {
    val navController = rememberNavController()

    AuthenticationProtocol {
        AttributeBasedAccessControl {
            Feature(
                navController = navController,
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SIconButton(
        onClick = {},
        iconResource = Res.drawable.ic_add
    )
}
