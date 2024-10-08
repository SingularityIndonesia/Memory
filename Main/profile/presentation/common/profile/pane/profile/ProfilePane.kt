package profile.pane.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.ui.designsystem.atom.STextTitle

@Composable
fun ProfilePane(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        STextTitle("Color Pane")
    }
}
