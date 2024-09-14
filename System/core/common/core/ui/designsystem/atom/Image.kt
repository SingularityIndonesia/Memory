package core.ui.designsystem.atom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import core.ui.SingularityScope
import core.ui.designsystem.boson.DesignToken
import core.ui.designsystem.boson.`extra-large-icon-size`
import core.ui.designsystem.boson.`large-icon-size`
import core.ui.designsystem.boson.`large-logo-size`
import core.ui.designsystem.boson.`medium-icon-size`
import core.ui.designsystem.boson.`medium-logo_size`
import core.ui.designsystem.boson.`small-icon-size`
import core.ui.designsystem.boson.`small-logo-size`

@Composable
fun SSmallIcon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
) {
    val attr = DesignToken.current
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier =
            Modifier
                .size(attr.`small-icon-size`)
                .then(modifier),
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
    )
}

@Composable
fun SMediumIcon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
) {
    val attr = DesignToken.current
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier =
            Modifier
                .size(attr.`medium-icon-size`)
                .then(modifier),
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
    )
}

@Composable
fun SLargeIcon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
) {
    val attr = DesignToken.current
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier =
            Modifier
                .size(attr.`large-icon-size`)
                .then(modifier),
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
    )
}

@Composable
fun SExtraLargeIcon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
) {
    val attr = DesignToken.current
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier =
            Modifier
                .size(attr.`extra-large-icon-size`)
                .then(modifier),
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
    )
}

context(SingularityScope)
@Composable
fun SSmallLogo(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    // contentScale: ContentScale = ContentScale.Fit,
    // alpha: Float = DefaultAlpha,
    // colorFilter: ColorFilter? = null
    onClick: () -> Unit = {},
) {
    val attr = DesignToken.current
    Card(
        onClick = {
            log("Logo clicked $contentDescription")
            onClick()
        },
        shape = CircleShape,
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier =
                Modifier
                    .size(attr.`small-logo-size`)
                    .then(modifier),
            alignment = alignment,
            contentScale = ContentScale.Fit,
            alpha = DefaultAlpha,
            colorFilter = null,
        )
    }
}

context(SingularityScope)
@Composable
fun SMediumLogo(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    // contentScale: ContentScale = ContentScale.Fit,
    // alpha: Float = DefaultAlpha,
    // colorFilter: ColorFilter? = null
    onClick: () -> Unit = {},
) {
    val attr = DesignToken.current
    Card(
        onClick = {
            log("Logo clicked $contentDescription")
            onClick()
        },
        shape = CircleShape,
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier =
                Modifier
                    .size(attr.`medium-logo_size`)
                    .then(modifier),
            alignment = alignment,
            contentScale = ContentScale.Fit,
            alpha = DefaultAlpha,
            colorFilter = null,
        )
    }
}

context(SingularityScope)
@Composable
fun SLargeLogo(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    // contentScale: ContentScale = ContentScale.Fit,
    // alpha: Float = DefaultAlpha,
    // colorFilter: ColorFilter? = null
    onClick: () -> Unit = {},
) {
    val attr = DesignToken.current
    Card(
        onClick = {
            log("Logo clicked $contentDescription")
            onClick()
        },
        shape = CircleShape,
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier =
                Modifier
                    .size(attr.`large-logo-size`)
                    .then(modifier),
            alignment = alignment,
            contentScale = ContentScale.Fit,
            alpha = DefaultAlpha,
            colorFilter = null,
        )
    }
}
