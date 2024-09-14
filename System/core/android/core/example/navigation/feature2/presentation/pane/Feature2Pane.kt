package core.example.navigation.feature2.presentation.pane

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import core.ui.SingularityScope
import core.ui.designsystem.atom.STextLabel
import core.ui.designsystem.atom.STextTitle

// # Pane1 -----------------------------------------------------------------------------------------
// put this in presentation module of feature 1's module
context(SingularityScope)
@Composable
fun Feature2Pane(magicNumber: Int) {
    Column {
        STextTitle(text = "Feature2Pane")
        STextLabel(text = "Magic Number = $magicNumber")
    }
}
