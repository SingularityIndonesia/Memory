package compose

import androidx.compose.runtime.Composable

@Composable
expect fun BackHandler(
    enable: Boolean,
    onBack: () -> Unit,
)
