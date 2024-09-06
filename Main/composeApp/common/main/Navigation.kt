/*
 * Copyright (c) 2024 Singularity Indonesia (stefanus.ayudha@gmail.com)
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import common.StateSaver
import core.ui.SingularityScope
import main.pane.dashboard.DashboardPane

context(SingularityScope)
@Composable
fun MainNavigation(
    navController: NavHostController,
    stateSaver: StateSaver,
) {
    NavHost(
        navController = navController,
        startDestination = "dashboard",
    ) {
        composable(
            route = "dashboard",
        ) {
            DashboardPane()
        }
    }
}
