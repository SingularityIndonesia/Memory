package core.example.navigation.composeApp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import core.example.navigation.composeApp.navigation.Feature2Route2Param
import core.example.navigation.feature1.presentation.pane.Feature1Pane
import core.example.navigation.feature2.presentation.pane.Feature2Pane
import core.navigation.UnitParam
import core.navigation.UnitResult
import core.navigation.navigate
import core.navigation.route
import core.ui.SingularityScope

context(SingularityScope)
@Composable
fun Navigation(controller: NavHostController) {
    NavHost(navController = controller, startDestination = "pane1") {
        route<UnitParam, UnitResult>(
            route = "pane1",
            title = "Feature1Pane",
            controller = controller,
            canGoBack = false,
        ) {
            Feature1Pane(
                onNext = {
                    val param = Feature2Route2Param(1)
                    navigate("pane2", param = param)
                },
            )
        }

        route<Feature2Route2Param, UnitResult>(
            route = "pane2",
            title = "Feature2Pane",
            controller = controller,
        ) {
            Feature2Pane(magicNumber = it.magicNumber)
        }
    }
}
