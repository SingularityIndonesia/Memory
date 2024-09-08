package development.example.presentation.atom

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import core.ui.designsystem.atom.STextLabel

@Composable
fun ExampleAtom(label: String) {
    STextLabel(text = label)
}

@Preview
@Composable
private fun Default() {
    ExampleAtom("Example Atom")
}
