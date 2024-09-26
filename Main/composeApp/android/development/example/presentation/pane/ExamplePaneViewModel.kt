package development.example.presentation.pane

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.adt.getOrElse
import core.adt.map
import core.tool.launch
import core.tool.postSideEffect
import core.tool.reduce
import development.example.model.ExampleModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.ensureActive
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

class ExamplePaneViewModel(
    private val exampleModel: ExampleModel = ExampleModel(),
) : ViewModel(),
    ContainerHost<ExamplePaneState, ExamplePaneSideEffect> {
    override val container: Container<ExamplePaneState, ExamplePaneSideEffect> =
        viewModelScope.container(ExamplePaneState())

    private var loadDataJob: Job? = null

    fun loadData() =
        intent {
            loadDataJob?.cancel()

            loadDataJob =
                launch {
                    reduce(true) { state.copy(showLoading = true, labelItems = emptyList()) }
                    val result = exampleModel.getEntities()

                    ensureActive()
                    val entities =
                        result
                            .map { entities ->
                                entities.map { it.label }
                            }.getOrElse { e ->
                                postSideEffect(
                                    ensureActive = true,
                                    sideEffect = ShowToast(e.localizedMessage ?: "Unknown Error"),
                                )
                                reduce(true) { state.copy(showLoading = false) }
                                return@launch cancel()
                            }

                    reduce(true) { state.copy(showLoading = false, labelItems = entities) }
                    postSideEffect(ShowToast("Load data success"))
                }
        }
}
