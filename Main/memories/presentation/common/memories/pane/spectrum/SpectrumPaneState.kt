package memories.pane.spectrum

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import memories.pane.spectrum.entity.SpectrumDisplay

data class SpectrumPaneState(
    val unit: Unit = Unit,
    val canLoadMore: Boolean = true,
    @Stable
    val spectrums: List<SpectrumDisplay> = emptyList()
)

class SpectrumPaneViewModel : ViewModel() {
    val state: StateFlow<SpectrumPaneState>
        field: MutableStateFlow<SpectrumPaneState> = MutableStateFlow(SpectrumPaneState())

    fun loadMore() {
        viewModelScope.launch {
            delay(3000)
            val spectrums = (0..20).map { i -> SpectrumDisplay("User $i", "Content $i") }
            state.update { state ->
                SpectrumPaneState(
                    spectrums = spectrums,
                    canLoadMore = false
                )
            }
        }
    }
}