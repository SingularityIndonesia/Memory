package authentication.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import core.ui.SingularityScope
import core.ui.designsystem.atom.Expand
import core.ui.designsystem.atom.SIconButton
import core.ui.designsystem.atom.SSmallIcon
import core.ui.designsystem.atom.STextLabel
import core.ui.designsystem.boson.DesignToken
import core.ui.designsystem.boson.`error-container`
import core.ui.designsystem.boson.`medium-padding`
import core.ui.designsystem.boson.`on-error-container`
import org.jetbrains.compose.resources.painterResource
import system.designsystem.resources.Res
import system.designsystem.resources.ic_close

context(SingularityScope)
@Composable
fun ErrorSnackBar(
    visible: Boolean,
    message: String,
    onClose: () -> Unit,
) {
    val attr = DesignToken.current
    AnimatedVisibility(visible = visible) {
        Snackbar(
            modifier = Modifier.padding(horizontal = attr.`medium-padding`),
            containerColor = attr.`error-container`,
            contentColor = attr.`on-error-container`,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                STextLabel(message)
                Expand()
                SIconButton(onClick = onClose) {
                    SSmallIcon(
                        painter = painterResource(Res.drawable.ic_close),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(attr.`on-error-container`),
                    )
                }
            }
        }
    }
}
