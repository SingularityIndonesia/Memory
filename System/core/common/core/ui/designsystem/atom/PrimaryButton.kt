package core.ui.designsystem.atom

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.ui.SingularityScope

context(SingularityScope)
@Composable
fun SPrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    // shape: Shape = ButtonDefaults.shape,
    // colors: ButtonColors = ButtonDefaults.buttonColors(),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    // border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    isLoading: Boolean = false,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = {
            log("Button $content clicked")
            if (!isLoading) {
                onClick.invoke()
            }
        },
        enabled = enabled,
        shape = ButtonDefaults.shape,
        colors = ButtonDefaults.buttonColors(),
        elevation = elevation,
        border = null,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier =
                    Modifier
                        .size(24.dp),
                color = MaterialTheme.colorScheme.onPrimary,
            )
        } else {
            content()
        }
    }
}

// # Extra -----------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------
context(SingularityScope)
@Composable
fun SPrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    isLoading: Boolean = false,
    labelText: String,
) {
    SPrimaryButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        elevation = elevation,
        interactionSource = interactionSource,
        isLoading = isLoading,
        content = {
            STextLabel(labelText)
        },
    )
}
