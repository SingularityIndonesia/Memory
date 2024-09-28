/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package main

import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import core.ui.navigation.Route
import core.ui.navigation.UnitParam
import core.ui.navigation.UnitResult
import main.pane.dashboard.DashboardPane

@Composable
fun Feature(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = DashboardRoute.route,
    ) {

        DashboardRoute<UnitParam, UnitResult>(
            modifier = Modifier
                .statusBarsPadding()
                .imePadding(),
            controller = navController,
        ) {
            DashboardPane()
        }

    }
}

val DashboardRoute = Route<UnitParam, UnitResult>(
    route = "dashboard",
    title = "Dashboard",
    canGoBack = false
)