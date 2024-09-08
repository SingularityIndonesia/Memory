package development.example.presentation.pane

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.operation.getOrElse
import core.operation.map
import development.example.model.ExampleModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

class ExamplePaneViewModel(
    private val exampleModel: ExampleModel = ExampleModel(),
) : ViewModel(),
    ContainerHost<ExamplePaneState, ExamplePaneSideEffect> {
    override val container: Container<ExamplePaneState, ExamplePaneSideEffect> =
        viewModelScope.container(ExamplePaneState())

    init {
        loadData()
    }

    fun loadData() =
        intent {
            reduce { state.copy(showLoading = true) }

            val result = exampleModel.getEntities()
            val entities =
                result
                    .map { entities ->
                        entities.map { it.label }
                    }.getOrElse { e ->
                        suspend {
                            postSideEffect(ShowToast(e.localizedMessage ?: "Unknown Error"))
                        }
                        return@intent
                    }

            reduce { state.copy(showLoading = false, labelItems = entities) }
        }

    fun showToast() =
        intent {
            postSideEffect(ShowToast("Singularity Indonesia"))
        }
}
