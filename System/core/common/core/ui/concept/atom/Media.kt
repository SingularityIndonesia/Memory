package core.ui.concept.atom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.ui.Concept

@Concept
@Composable
fun Media(modifier: Modifier = Modifier) {
    Box(
        // fixme: hardcoded size
        modifier =
            Modifier
                .height(200.dp)
                .border(BorderStroke(1.dp, Color.Black))
                .then(modifier),
    ) {
        Text(text = "Media")
    }
}
