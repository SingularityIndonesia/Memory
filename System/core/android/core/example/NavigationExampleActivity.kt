package core.example

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import core.example.navigation.composeApp.Navigation
import core.ui.SingularityApp
import simpleactivity.SimpleActivity

class NavigationExampleActivity : SimpleActivity() {
    @Composable
    override fun App() {
        SingularityApp {
            val controller = rememberNavController()
            Navigation(controller = controller)
        }
    }
}
