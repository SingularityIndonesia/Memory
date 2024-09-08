package development.example.presentation.pane

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import core.ui.SingularityApp
import core.ui.SingularityScope
import core.ui.designsystem.atom.Expand
import core.ui.designsystem.atom.SMediumSpacing
import core.ui.designsystem.atom.SPrimaryButton
import core.ui.designsystem.atom.STextLabel
import development.example.presentation.organism.ExampleOrganism
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

context(SingularityScope)
@Composable
fun ExamplePane(viewModel: ExamplePaneViewModel = viewModel()) {
    val context = LocalContext.current // example purpose only, do not depend on OS Context
    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is ShowToast -> Toast.makeText(context, sideEffect.message, Toast.LENGTH_LONG).show()
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        SMediumSpacing()
        ExampleOrganism(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )

        // display entities
        if (state.labelItems.isNotEmpty()) {
            EntitiesLabelList(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                list = state.labelItems,
            )
        }

        if (state.showLoading) {
            CircularProgressIndicator(
                modifier =
                    Modifier
                        .padding(horizontal = 16.dp),
            )
        }

        Expand()
        SPrimaryButton(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            onClick = { viewModel.loadData() },
            labelText = "Load Data",
        )
        SMediumSpacing()
    }
}

@Composable
fun EntitiesLabelList(
    modifier: Modifier = Modifier,
    list: List<String>,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        list.map {
            STextLabel(text = it)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Default() {
    SingularityApp {
        ExamplePane()
    }
}
