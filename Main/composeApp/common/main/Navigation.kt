/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import main.pane.dashboard.DashboardPane

@Composable
fun Feature(navController: NavHostController) {
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
