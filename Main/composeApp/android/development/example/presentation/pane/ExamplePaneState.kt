package development.example.presentation.pane

data class ExamplePaneState(
    val showLoading: Boolean = false,
    val labelItems: List<String> = emptyList()
)