package core.ui.concept.atom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.ui.Concept
import core.ui.designsystem.boson.DesignToken
import core.ui.designsystem.boson.`media-thumbnail-size`

@Concept
@Composable
fun MediaThumbnail(modifier: Modifier = Modifier) {
    val attr = DesignToken.current
    Box(
        modifier =
            Modifier
                .size(attr.`media-thumbnail-size`)
                .border(BorderStroke(1.dp, Color.Black))
                .then(modifier),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Media")
    }
}
