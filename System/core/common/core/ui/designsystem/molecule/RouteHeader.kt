package core.ui.designsystem.molecule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import core.SystemToken
import core.ui.designsystem.atom.SIconButton
import core.ui.designsystem.atom.SLargeSpacing
import core.ui.designsystem.atom.STextTitle
import core.ui.designsystem.boson.`medium-spacing`
import org.jetbrains.compose.resources.painterResource
import system.designsystem.resources.Res
import system.designsystem.resources.ic_arrow_back

@Composable
fun SRouteHeader(
    title: String,
    onBack: () -> Unit,
) {
    val attr = SystemToken.current
    Row(
        horizontalArrangement = Arrangement.spacedBy(attr.`medium-spacing`),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SIconButton(
            onClick = onBack,
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_arrow_back),
                contentDescription = null,
            )
        }

        STextTitle(text = title)
        SLargeSpacing()
    }
}
