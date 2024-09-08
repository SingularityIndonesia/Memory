package development.example.presentation.molecule

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import core.ui.Concept
import core.ui.designsystem.molecule.STextLabel

@Concept
@Composable
fun ExampleMoleculeConcept() {
    Box(
        modifier = Modifier.border(border = BorderStroke(1.dp, Color.Black)),
    ) {
        STextLabel(text = "Example Molecule Concept")
    }
}

@Preview
@Composable
private fun Default() {
    ExampleMoleculeConcept()
}
