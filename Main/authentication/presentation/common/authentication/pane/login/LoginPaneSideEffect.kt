package authentication.pane.login

sealed class LoginPaneSideEffect

data class ShowErrorToast(
    val message: String,
) : LoginPaneSideEffect()
