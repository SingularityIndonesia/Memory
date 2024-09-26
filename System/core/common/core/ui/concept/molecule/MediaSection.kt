package core.ui.concept.molecule

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.SystemToken
import core.ui.Concept
import core.ui.concept.atom.Media
import core.ui.concept.atom.MediaThumbnail
import core.ui.designsystem.boson.`large-spacing`
import core.ui.designsystem.boson.`media-thumbnail-size`
import core.ui.designsystem.boson.`medium-spacing`
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import system.designsystem.resources.Res
import system.designsystem.resources.ic_photo_library

@Concept
@Composable
fun MediaSection(modifier: Modifier = Modifier) {
    val attr = SystemToken.current

    Row(
        modifier =
            Modifier
                .border(BorderStroke(1.dp, Color.Black))
                .then(modifier),
        horizontalArrangement = Arrangement.spacedBy(attr.`large-spacing`),
    ) {
        Media(
            modifier = Modifier.weight(1f),
        )
        MediaThumbnailSection()
    }
}

@Concept
@Composable
fun MediaThumbnailSection(modifier: Modifier = Modifier) {
    val attr = SystemToken.current
    Column(
        modifier =
            Modifier
                .border(BorderStroke(1.dp, Color.Black))
                .then(modifier),
        verticalArrangement = Arrangement.spacedBy(attr.`medium-spacing`),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MediaThumbnail()
        MediaThumbnail()

        IconButton(
            modifier =
                Modifier
                    .size(attr.`media-thumbnail-size`)
                    .border(BorderStroke(1.dp, Color.Black)),
            onClick = {},
        ) {
            Icon(
                painter = painterResource(resource = Res.drawable.ic_photo_library),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    MediaSection()
}
