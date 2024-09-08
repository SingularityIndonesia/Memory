package development.example.presentation.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import core.ui.SingularityApp
import core.ui.SingularityScope
import development.example.presentation.atom.ExampleAtom
import development.example.presentation.molecule.ExampleMoleculeConcept

context(SingularityScope)
@Composable
fun ExampleOrganism(
    modifier: Modifier = Modifier
) {
    val clickCounter = remember { mutableIntStateOf(0) }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        ExampleAtom("Click counter ${clickCounter.intValue}")
        ExampleMoleculeConcept(
            onClick = {
                clickCounter.intValue += 1 // lambda capture state, just for example
            }
        )
    }
}

@Preview
@Composable
private fun Default() {
    SingularityApp {
        ExampleOrganism()
    }
}
