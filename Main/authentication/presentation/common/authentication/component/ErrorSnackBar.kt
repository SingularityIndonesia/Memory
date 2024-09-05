package authentication.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import core.ui.SingularityScope
import core.ui.designsystem.DesignToken
import core.ui.designsystem.component.Expand
import core.ui.designsystem.component.SIconButton
import core.ui.designsystem.component.SSmallIcon
import core.ui.designsystem.component.STextLabel
import core.ui.designsystem.`medium-padding`
import org.jetbrains.compose.resources.painterResource
import system.designsystem.resources.Res
import system.designsystem.resources.logo_of_singularity_indonesia_circle

context(SingularityScope)
@Composable
fun ErrorSnackBar(
    visible: Boolean,
    message: String,
    onClose: () -> Unit,
) {
    val attr = DesignToken.current
    AnimatedVisibility(visible = visible) {
        Snackbar(modifier = Modifier.padding(horizontal = attr.`medium-padding`)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                STextLabel(message)
                Expand()
                SIconButton(onClick = onClose) {
                    SSmallIcon(
                        painter = painterResource(Res.drawable.logo_of_singularity_indonesia_circle),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}
