package core.ui.designsystem.molecule

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import core.ui.SingularityScope
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

context(SingularityScope)
@Composable
fun SIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit,
) {
    IconButton(
        onClick = {
            log("Button clicked $content")
            onClick()
        },
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        interactionSource = interactionSource,
        content = content,
    )
}

// # Extra -----------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------
context(SingularityScope)
@Composable
fun SIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    iconResource: DrawableResource,
) {
    SIconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        content = {
            Icon(
                painter = painterResource(iconResource),
                contentDescription = null,
            )
        },
    )
}
