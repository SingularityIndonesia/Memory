package core.ui.tool

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import core.SystemToken
import core.ui.designsystem.atom.SLargeIcon
import core.ui.designsystem.atom.SSmallLogo
import core.ui.designsystem.atom.STextSubTitle
import core.ui.designsystem.atom.STextTitle
import core.ui.designsystem.boson.`medium-padding`
import core.ui.designsystem.boson.`medium-spacing`
import core.ui.designsystem.boson.`small-padding`
import core.ui.designsystem.boson.`small-spacing`
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import system.designsystem.resources.Res
import system.designsystem.resources.logo_of_singularity_indonesia_circle

const val SHIMMER_DURATION = 1000

@Composable
fun Modifier.shimmer(
    show: Boolean = false,
    cornerRadius: Dp = 8.dp,
    animationLabel: String = "Shimmer",
): Modifier {
    val attr = SystemToken.current
    var size by remember { mutableStateOf(IntSize.Zero) }
    val transition = rememberInfiniteTransition(label = animationLabel)
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec =
            infiniteRepeatable(
                animation = tween(SHIMMER_DURATION),
            ),
        label = animationLabel,
    )

    return this
        .drawWithContent {
            drawContent()
            if (show) {
                drawRoundRect(
                    brush =
                        Brush.linearGradient(
                            colors =
                                listOf(
                                    Color(0xFFCCCCCC),
                                    Color(0xFFA3A3A3),
                                    Color(0xFFCCCCCC),
                                ),
                            start = Offset(startOffsetX, 0f),
                            end =
                                Offset(
                                    startOffsetX + size.width.toFloat(),
                                    size.height.toFloat(),
                                ),
                        ),
                    size = size.toSize(),
                    cornerRadius = CornerRadius(cornerRadius.toPx()),
                )
            }
        }.onSizeChanged { size = it }
}

@Preview
@Composable
fun ShimmerPreview() {
    val attr = SystemToken.current
    var isLoading by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.padding(attr.`medium-padding`),
        horizontalArrangement = Arrangement.spacedBy(attr.`medium-spacing`),
    ) {
        SSmallLogo(
            modifier =
                Modifier
                    .shimmer(
                        show = isLoading,
                        cornerRadius = 100.dp,
                    ),
            painter = painterResource(Res.drawable.logo_of_singularity_indonesia_circle),
            contentDescription = null,
        )
        Column {
            STextTitle(
                modifier =
                    Modifier
                        .defaultMinSize(minWidth = 100.dp)
                        .shimmer(
                            show = isLoading,
                            cornerRadius = 8.dp,
                        ),
                text = "Steve",
            )
            STextSubTitle(
                modifier =
                    Modifier
                        .defaultMinSize(minWidth = 200.dp)
                        .shimmer(
                            show = isLoading,
                            cornerRadius = 8.dp,
                        ),
                text = "The Best",
            )
        }
    }

    LaunchedEffect(isLoading) {
        delay(2000)
        isLoading = !isLoading
    }
}
