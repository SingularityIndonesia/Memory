package main.pane.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

/**
 * Created by: Muhammad Jafar
 * At: 16.09.24
 * Find me: 131.powerfull@gmail.com
 */

sealed class LoginPaneSideEffect

class LoginPaneViewModel : ViewModel(),
    ContainerHost<LoginPaneState, LoginPaneSideEffect> {

    override val container: Container<LoginPaneState, LoginPaneSideEffect> =
        viewModelScope.container(LoginPaneState())

    fun doLogin() =
        intent {
            reduce { state.copy(isAuthReady = true) }
        }

    fun saveToken(token: String) =
        intent {
            reduce { state.copy(token = token) }
        }
}
