package core.example.navigation.feature1.presentation.pane

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import core.ui.SingularityScope
import core.ui.designsystem.atom.SPrimaryButton
import core.ui.designsystem.atom.STextTitle

// # Pane1 -----------------------------------------------------------------------------------------
// put this in presentation module of feature 1's module
context(SingularityScope)
@Composable
fun Feature1Pane(onNext: () -> Unit) {
    Column {
        STextTitle(text = "Feature1Pane")
        SPrimaryButton(onClick = onNext, labelText = "Next")
    }
}