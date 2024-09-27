package authentication.pane.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import authentication.AuthenticationRepository
import authentication.AuthenticationService
import core.adt.SystemResult
import core.adt.onSuccess
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import profile.ProfileRepository
import profile.ProfileService

class LoginViewModel(
    private val repository: AuthenticationRepository = AuthenticationService(),
    private val profileModel: ProfileRepository = ProfileService(),
) : ViewModel(),
    ContainerHost<LoginPaneState, LoginPaneSideEffect> {
    override val container: Container<LoginPaneState, LoginPaneSideEffect> =
        viewModelScope.container(LoginPaneState())

    fun login() =
        intent {
            reduce { state.copy(showLoading = true) }
            val result =
                repository
                    .login()
                    .onSuccess { data ->
                        viewModelScope.launch {
                            repository.saveToken(data.token)
                            // profileModel.saveUserBasicInfo(data.user)
                        }
                    }

            val newState =
                when (result) {
                    is SystemResult.Success -> {
                        state.copy(
                            showLoading = false,
                        )
                    }

                    is SystemResult.Error ->
                        state.copy(
                            showLoading = false,
                            showLoginErrorSnackBar = true,
                            loginErrorSnackBarMessage = "Login Failed: ${result.e.cause?.message}",
                        )
                }

            reduce { newState }
        }

    fun closeLoginBottomSheet() =
        intent {
            reduce { state.copy(showBottomSheet = false) }
        }

    fun dismissLoginErrorSnackBar() =
        intent {
            reduce { state.copy(showLoginErrorSnackBar = false) }
        }
}
