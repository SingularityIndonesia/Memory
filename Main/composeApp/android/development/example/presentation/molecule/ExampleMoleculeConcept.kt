package development.example.presentation.molecule

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import core.ui.Concept
import core.ui.SingularityApp
import core.ui.SingularityScope
import core.ui.designsystem.atom.Expand
import core.ui.designsystem.atom.SSecondaryButton
import core.ui.designsystem.atom.STextLabel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

context(SingularityScope)
@Concept
@Composable
fun ExampleMoleculeConcept(
    label: String? = null,
    onClick: (() -> Unit)? = null,
) {
    val scope = rememberCoroutineScope()
    val actualLabel = remember(label) { mutableStateOf(label ?: "Example Molecule") }

    DisposableEffect(key1 = actualLabel.value) {
        if (onClick != null) return@DisposableEffect  onDispose {  }

        val job: Job =
            scope.launch {
                delay(300)
                actualLabel.value = "Example Molecule Concept"
            }

        onDispose { job.cancel() }
    }

    Row(
        modifier = Modifier.border(border = BorderStroke(1.dp, Color.Black)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        STextLabel(text = actualLabel.value)
        Expand()
        SSecondaryButton(
            onClick = onClick ?: { actualLabel.value = "Auch" },
            labelText = "Click Me",
        )
    }
}

@Preview
@Composable
private fun Default() {
    SingularityApp {
        ExampleMoleculeConcept()
    }
}
