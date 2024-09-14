package navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavController

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

@Composable
fun <R : NavigationResult> routeScope(controller: NavController): RouteScope<R> {
    val scope =
        object : RouteScope<R> {
            @OptIn(IllegalAccess::class)
            override val controller: NavController = controller

            override fun goBack() {
                controller.popBackStack()
            }

            override fun returnResult(result: R) {
            }
        }

    return scope
}
