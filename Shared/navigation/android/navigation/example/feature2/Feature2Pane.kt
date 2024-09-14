package navigation.example.feature2

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// # Pane1 -----------------------------------------------------------------------------------------
// put this in presentation module of feature 1's module
@Composable
fun Feature2Pane(magicNumber: Int) {
    Column {
        Text(text = "Feature2Pane")
        Text(text = "Magic Number = $magicNumber")
    }
}
