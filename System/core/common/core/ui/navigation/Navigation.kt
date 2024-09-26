package core.ui.navigation

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

interface UrlParam

@Serializable
object UnitParam : UrlParam

interface NavigationResult

@Serializable
object UnitResult : NavigationResult

context(RouteScope<R>)
inline fun <reified P : UrlParam, R : NavigationResult> navigate(
    route: Route<P, R>,
    param: P,
) {
    val routeWithParam = "${route.route}?param=${Json.encodeToString(param)}"

    @OptIn(IllegalAccess::class)
    controller.navigate(routeWithParam)
}
