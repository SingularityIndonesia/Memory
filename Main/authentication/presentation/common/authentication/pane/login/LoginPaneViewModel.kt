package authentication.pane.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import authentication.AuthenticationModel
import core.operation.SystemResult
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

class LoginViewModel(
    private val authenticationModel: AuthenticationModel = AuthenticationModel(),
) : ViewModel(),
    ContainerHost<LoginPaneState, LoginPaneSideEffect> {
    override val container: Container<LoginPaneState, LoginPaneSideEffect> =
        viewModelScope.container(LoginPaneState())

    fun login() =
        intent {
            reduce { state.copy(showLoading = true) }

            val result = authenticationModel.login()
            val newState =
                when (result) {
                    is SystemResult.Success ->
                        state.copy(
                            showLoading = false,
                        )
                    is SystemResult.Error ->
                        state.copy(
                            showLoading = false,
                            showLoginErrorSnackBar = true,
                            loginErrorSnackBarMessage = "Login Failed: ${result.e.message}",
                        )
                }

            reduce { newState }
        }

    fun closeLoginBottomSheet() =
        intent {
            reduce { state.copy(showBottomSheet = false) }
        }

    fun dismissSnackBar() =
        intent {
            reduce { state.copy(showLoginErrorSnackBar = false) }
        }
}
