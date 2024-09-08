package development.example.presentation.molecule

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import core.ui.designsystem.molecule.STextLabel

@Composable
fun ExampleMolecule() {
    STextLabel(text = "Example Molecule")
}

@Preview
@Composable
private fun Default() {
    ExampleMolecule()
}
