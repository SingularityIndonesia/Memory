package development.example.presentation.pane

sealed class ExamplePaneSideEffect

data class ShowToast(
    val message: String,
) : ExamplePaneSideEffect()
