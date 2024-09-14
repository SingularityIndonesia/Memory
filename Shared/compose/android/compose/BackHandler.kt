package compose

import androidx.compose.runtime.Composable

@Composable
actual fun BackHandler(
    enable: Boolean,
    onBack: () -> Unit,
) {
    androidx.activity.compose.BackHandler(enable, onBack)
}
