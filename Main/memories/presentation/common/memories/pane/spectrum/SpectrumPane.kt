package memories.pane.spectrum

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import core.ui.designsystem.atom.STextTitle

@Composable
fun SpectrumPane(
    modifier: Modifier = Modifier,
    viewModel: SpectrumPaneViewModel = viewModel(),
) {
    val state: SpectrumPaneState by viewModel.state.collectAsState()

    LaunchedEffect(state) {
        print("asldna $state")
    }

    Column(
        modifier = modifier,
    ) {
        STextTitle("Spectrum Pane")
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            state.spectrums.map { display ->
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text("User name: ${display.userName}")
                            Text("Content: ${display.content}")
                        }
                    }
                }
            }
            item(state.canLoadMore) {
                if (state.canLoadMore) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                    viewModel.loadMore()
                }
            }
        }
    }
}
