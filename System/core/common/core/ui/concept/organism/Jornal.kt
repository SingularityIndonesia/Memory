package core.ui.concept.organism

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.ui.Concept
import core.ui.SingularityApp
import core.ui.concept.molecule.MediaSection
import core.ui.designsystem.boson.DesignToken
import core.ui.designsystem.boson.`large-spacing`
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import system.designsystem.resources.Res
import system.designsystem.resources.ic_calendar_month
import system.designsystem.resources.ic_edit

@Concept
@Composable
fun Journal(modifier: Modifier = Modifier) {
    val attr = DesignToken.current
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(attr.`large-spacing`),
    ) {
        MediaSection()
        DateSection()
        SpectrumSection()
        QuoteSection()
        StorySection()
    }
}

@Concept
@Composable
private fun DateSection(modifier: Modifier = Modifier) {
    Row(
        modifier =
            Modifier
                .border(BorderStroke(1.dp, Color.Black))
                .then(modifier),
    ) {
        Text(
            modifier =
                Modifier
                    .weight(1f)
                    .border(BorderStroke(1.dp, Color.Black)),
            text = "Aug 24th, 2024",
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(resource = Res.drawable.ic_calendar_month),
                contentDescription = null,
            )
        }
    }
}

@Concept
@Composable
private fun SpectrumSection(modifier: Modifier = Modifier) {
    Row(
        modifier =
            Modifier
                .border(BorderStroke(1.dp, Color.Black))
                .then(modifier),
    ) {
        Text(
            modifier =
                Modifier
                    .weight(1f)
                    .border(BorderStroke(1.dp, Color.Black)),
            text = "#Friend #Dumb",
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(resource = Res.drawable.ic_edit),
                contentDescription = null,
            )
        }
    }
}

@Concept
@Composable
private fun QuoteSection(modifier: Modifier = Modifier) {
    Row(
        modifier =
            Modifier
                .border(BorderStroke(1.dp, Color.Black))
                .then(modifier),
    ) {
        Text(
            modifier =
                Modifier
                    .weight(1f)
                    .border(BorderStroke(1.dp, Color.Black)),
            text = "Lorem Ipsum Dolor",
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(resource = Res.drawable.ic_edit),
                contentDescription = null,
            )
        }
    }
}

@Concept
@Composable
private fun StorySection(modifier: Modifier = Modifier) {
    Row(
        modifier =
            Modifier
                .border(BorderStroke(1.dp, Color.Black))
                .then(modifier),
    ) {
        Text(
            modifier =
                Modifier
                    .weight(1f)
                    .border(BorderStroke(1.dp, Color.Black)),
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras dignissim congue tellus eget venenatis. Nam nec ornare sapien. Duis mi ante, consequat eu sollicitudin eu, vestibulum et erat. Phasellus convallis felis arcu, vel congue neque tincidunt sit amet. Donec eu cursus urna, sit amet rutrum neque. Aenean porttitor hendrerit augue. Nulla ut odio vitae quam posuere suscipit non vel ipsum.",
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(resource = Res.drawable.ic_edit),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    SingularityApp {
        Journal()
    }
}
