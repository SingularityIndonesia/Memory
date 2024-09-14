package core.example.navigation.composeApp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import core.example.navigation.feature1.presentation.pane.Feature1Pane
import core.example.navigation.feature2.presentation.pane.Feature2Pane
import core.navigation.Route
import core.navigation.UnitParam
import core.navigation.UnitResult
import core.navigation.UrlParam
import core.navigation.navigate
import core.ui.SingularityScope
import kotlinx.serialization.Serializable

context(SingularityScope)
@Composable
fun Navigation(controller: NavHostController) {
    NavHost(navController = controller, startDestination = Feature1Route.route) {
        Feature1Route<UnitParam, UnitResult>(
            controller = controller,
        ) {
            Feature1Pane(
                onNext = {
                    val param = Feature2RouteParam(1)
                    navigate(route = Feature2Route, param = param)
                },
            )
        }

        Feature2Route<Feature2RouteParam, UnitResult>(
            controller = controller,
        ) {
            Feature2Pane(magicNumber = it.magicNumber)
        }
    }
}

// # Feature 2 -------------------------------------------------------------------------------------
val Feature1Route =
    Route<UnitParam, UnitResult>(route = "feature1", title = "Feature 1", canGoBack = false)

// # Feature 2 -------------------------------------------------------------------------------------
// Note: never parse complex object to the parameter
// Parse only essentials parameter like identifier and intent
@Serializable
data class Feature2RouteParam(
    val magicNumber: Int,
) : UrlParam

val Feature2Route = Route<Feature2RouteParam, UnitResult>(route = "feature2", title = "Feature 2")
