package dashboard.pane.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.ui.designsystem.component.STextTitle
import post.pane.post.PostPane

@Composable
fun HomePane(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        STextTitle("Home Pane")
        PostPane()
    }
}
