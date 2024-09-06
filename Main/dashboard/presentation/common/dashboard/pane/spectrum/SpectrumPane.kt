package dashboard.pane.spectrum

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.ui.designsystem.component.STextTitle
import post.pane.post.PostPane

@Composable
fun SpectrumPane(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        STextTitle("Spectrum Pane")
        PostPane()
    }
}
