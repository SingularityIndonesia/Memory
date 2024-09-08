package memories.pane.spectrum

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.ui.designsystem.atom.STextTitle

@Composable
fun SpectrumPane(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        STextTitle("Spectrum Pane")
    }
}
