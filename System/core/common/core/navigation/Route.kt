package core.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import compose.BackHandler
import core.ui.SingularityScope
import core.ui.designsystem.molecule.SRouteHeader
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@RequiresOptIn(message = "Do not use this, this property should no be expose anywhere.")
@Retention(value = AnnotationRetention.BINARY)
annotation class IllegalAccess

@Stable
interface RouteScope<R : NavigationResult> {
    @IllegalAccess
    val controller: NavController

    fun goBack()

    fun returnResult(result: R)
}

context(RouteScope<R>)
inline fun <reified T : UrlParam, R : NavigationResult> navigate(
    route: String,
    param: T,
) {
    val routeWithParam = "$route?param=${Json.encodeToString(param)}"

    @OptIn(IllegalAccess::class)
    controller.navigate(routeWithParam)
}

context(SingularityScope, NavGraphBuilder)
inline fun <reified P : UrlParam, R : NavigationResult> route(
    route: String,
    title: String,
    controller: NavController,
    canGoBack: Boolean = true,
    crossinline panel: @Composable RouteScope<R>.(P) -> Unit,
) {
    composable(
        route = "$route?param={param}",
        arguments =
            listOf(
                navArgument("param") {
                    defaultValue = "{}"
                    type = NavType.StringType
                },
            ),
    ) { backStackEntry ->
        val scope =
            remember(this@NavGraphBuilder.provider) {
                object : RouteScope<R> {
                    @OptIn(IllegalAccess::class)
                    override val controller: NavController = controller

                    override fun goBack() {
                        if (canGoBack) {
                            controller.popBackStack()
                        }
                    }

                    override fun returnResult(result: R) {
                    }
                }
            }

        val param: P =
            run {
                val serializedParam: String = backStackEntry.arguments?.getString("param") ?: "{}"
                Json.decodeFromString(serializedParam)
            }

        with(scope) {
            if (canGoBack) {
                RouteContent(
                    title = title,
                    param = param,
                    panel = panel,
                )
            } else {
                RouteContentNoHeader(
                    param = param,
                    panel = panel,
                )
            }
        }
    }
}

context(SingularityScope, RouteScope<R>)
@Composable
inline fun <reified P : UrlParam, R : NavigationResult> RouteContent(
    title: String,
    param: P,
    panel: @Composable RouteScope<R>.(P) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        SRouteHeader(
            title = title,
            onBack = { goBack() },
        )
        panel.invoke(this@RouteScope, param)
    }
}

context(SingularityScope, RouteScope<R>)
@Composable
inline fun <reified P : UrlParam, R : NavigationResult> RouteContentNoHeader(
    param: P,
    panel: @Composable RouteScope<R>.(P) -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        BackHandler(enable = true, onBack = {
            // can't go back
        })

        panel.invoke(this@RouteScope, param)
    }
}
