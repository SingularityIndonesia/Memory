package development.example.presentation.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import development.example.presentation.molecule.ExampleMolecule
import development.example.presentation.molecule.ExampleMoleculeConcept

@Composable
fun ExampleOrganism() {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        ExampleMolecule()
        ExampleMoleculeConcept()
    }
}


@Preview
@Composable
private fun Default() {
    ExampleOrganism()
}
