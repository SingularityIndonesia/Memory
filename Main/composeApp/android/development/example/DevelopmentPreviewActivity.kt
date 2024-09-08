package development.example

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import core.ui.SingularityApp
import development.example.presentation.pane.ExamplePane
import simpleactivity.SimpleActivity

class DevelopmentPreviewActivity : SimpleActivity() {
    @Composable
    override fun App() {
        SingularityApp {
            ExamplePane() // replace this with your module
        }
    }
}
