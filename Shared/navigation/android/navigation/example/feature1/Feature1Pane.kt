package navigation.example.feature1

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// # Pane1 -----------------------------------------------------------------------------------------
// put this in presentation module of feature 1's module
@Composable
fun Feature1Pane(onNext: () -> Unit) {
    Column {
        Text(text = "Feature1Pane")
        Button(onClick = onNext) {
            Text(text = "Next")
        }
    }
}
