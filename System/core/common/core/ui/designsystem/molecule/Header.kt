package core.ui.designsystem.molecule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import core.SystemToken
import core.ui.designsystem.atom.Expand
import core.ui.designsystem.atom.SIconButton
import core.ui.designsystem.atom.SLargeSpacing
import core.ui.designsystem.atom.STextTitle
import core.ui.designsystem.boson.`large-spacing`
import core.ui.designsystem.boson.`medium-spacing`
import system.designsystem.resources.Res
import system.designsystem.resources.ic_arrow_back

@Composable
fun SHeader(
    leadingIcon: (@Composable RowScope.() -> Unit)? = null,
    title: (@Composable RowScope.() -> Unit)? = null,
    trailingIcon: (@Composable RowScope.() -> Unit)? = null,
) {
    val attr = SystemToken.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(attr.`medium-spacing`),
    ) {
        if (leadingIcon == null) {
            // provide padding using arrangement
            Spacer(modifier = Modifier.width(attr.`large-spacing` - attr.`medium-spacing`))
        } else {
            leadingIcon.invoke(this)
        }
        title?.invoke(this)
        Expand()
        if (trailingIcon == null) {
            SLargeSpacing()
        } else {
            trailingIcon.invoke(this)
        }
    }
}

@Composable
fun SHeader(
    titleText: String,
    trailingIcon: (@Composable RowScope.() -> Unit)? = null,
    onBack: () -> Unit,
) {
    SHeader(
        title = {
            STextTitle(modifier = Modifier.weight(1f), text = titleText)
        },
        leadingIcon = {
            SIconButton(
                onClick = onBack,
                iconResource = Res.drawable.ic_arrow_back,
            )
        },
        trailingIcon = trailingIcon,
    )
}
