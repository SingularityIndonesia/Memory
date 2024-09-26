package core.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import core.ui.tool.BackHandler
import kotlinx.serialization.json.Json

/**
 * @param canGoBack if true top navigator will be shown and back action will be intercepted
 */
data class Route<P : UrlParam, R : NavigationResult>(
    val route: String,
    val title: String,
    val canGoBack: Boolean = true,
) {
    context(NavGraphBuilder)
    inline operator fun <reified P : UrlParam, R : NavigationResult> invoke(
        controller: NavHostController,
        noinline header: (@Composable (title: String, onBack: () -> Unit) -> Unit)? = null,
        crossinline content: @Composable RouteScope<R>.(P) -> Unit,
    ) {
        route<P, R>(
            route = route,
            title = title,
            canGoBack = canGoBack,
            controller = controller,
            header = header,
            content = content,
        )
    }
}

context(NavGraphBuilder)
inline fun <reified P : UrlParam, R : NavigationResult> route(
    route: String,
    title: String,
    controller: NavController,
    canGoBack: Boolean = true,
    noinline header: (@Composable (title: String, onBack: () -> Unit) -> Unit)? = null,
    crossinline content: @Composable RouteScope<R>.(P) -> Unit,
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

        val scope = routeScope<R>(controller)

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
                    header = header,
                    panel = content,
                )
            } else {
                RouteContentCantGoBack(
                    param = param,
                    panel = content,
                )
            }
        }
    }
}

// # Route Containers ------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------
context(RouteScope<R>)
@Composable
inline fun <reified P : UrlParam, R : NavigationResult> RouteContent(
    title: String,
    param: P,
    noinline header: (@Composable (title: String, onBack: () -> Unit) -> Unit)? = null,
    panel: @Composable RouteScope<R>.(P) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        if (header == null) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = ::goBack,
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = "back",
                    )
                }
                Text(title, style = MaterialTheme.typography.titleMedium)
            }
        } else {
            header.invoke(title, ::goBack)
        }

        panel.invoke(this@RouteScope, param)
    }
}

context(RouteScope<R>)
@Composable
inline fun <reified P : UrlParam, R : NavigationResult> RouteContentCantGoBack(
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
