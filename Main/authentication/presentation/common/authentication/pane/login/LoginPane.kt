package authentication.pane.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import authentication.modal.LoginBottomSheet
import core.ui.SingularityApp
import core.ui.SingularityScope
import core.ui.designsystem.DesignToken
import core.ui.designsystem.component.Expand
import core.ui.designsystem.component.SIconButton
import core.ui.designsystem.component.SSmallIcon
import core.ui.designsystem.component.STextLabel
import core.ui.designsystem.`medium-padding`
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import system.designsystem.resources.Res
import system.designsystem.resources.logo_of_singularity_indonesia_circle

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

    AnimatedVisibility(visible = state.showLoginErrorSnackBar) {
        Snackbar(modifier = Modifier.padding(horizontal = attr.`medium-padding`)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                STextLabel(state.loginErrorSnackBarMessage)
                Expand()
                SIconButton(onClick = { viewModel.dismissSnackBar() }) {
                    SSmallIcon(
                        painter = painterResource(Res.drawable.logo_of_singularity_indonesia_circle),
                        contentDescription = null,
                    )
                }
            }
        }
    }

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
