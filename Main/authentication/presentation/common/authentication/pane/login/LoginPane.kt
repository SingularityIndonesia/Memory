package authentication.pane.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import authentication.component.ErrorSnackBar
import authentication.modal.LoginBottomSheet
import core.ui.SingularityApp
import core.ui.SingularityScope
import core.ui.designsystem.DesignToken
import org.jetbrains.compose.ui.tooling.preview.Preview

data class LoginPaneState(
    val showLoginErrorSnackBar: Boolean = false,
    val loginErrorSnackBarMessage: String = "",
    val showBottomSheet: Boolean = true,
    val showLoading: Boolean = false,
)

context(SingularityScope)
@Composable
fun LoginPane(viewModel: LoginViewModel = viewModel()) {
    val attr = DesignToken.current
    val state by viewModel.container.stateFlow.collectAsState()

    ErrorSnackBar(
        state.showLoginErrorSnackBar,
        state.loginErrorSnackBarMessage,
        onClose = { viewModel.dismissLoginErrorSnackBar() },
    )

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        if (state.showBottomSheet) {
            LoginBottomSheet(
                showLoading = state.showLoading,
                onDismissRequest = {
                    viewModel.closeLoginBottomSheet()
                },
                onLogin = {
                    viewModel.login()
                },
            )
        }
    }
}

@Preview
@Composable
private fun Default() {
    SingularityApp {
        // LoginPane()
    }
}
