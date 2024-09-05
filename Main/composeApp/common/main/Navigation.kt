/*
 * Copyright (c) 2024 Singularity Indonesia (stefanus.ayudha@gmail.com)
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import common.StateSaver
import core.ui.SingularityScope

context(SingularityScope, MainContext)
@Composable
fun MainNavigation(
    navController: NavHostController,
    stateSaver: StateSaver,
) {
//    NavHost(
//        navController = navController,
//        startDestination = DashboardRoute.ROUTE,
//    ) {
//
//        composable(
//            route = DashboardRoute.ROUTE,
//        ) {
//            with(dashboardContext) {
//                DashboardPane(
//                    gotoGroot = {
//                        navController.navigate("groot")
//                    },
//                    gotoTodoDetail = {
//                        navController.navigate("todo-detail/${it.value}")
//                    },
//                )
//            }
//        }
//    }
}
