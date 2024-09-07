package main.protocol

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import authentication.pane.login.LoginPane
import core.exception.AuthenticationException
import core.operation.SystemResult
import core.protocol.AccessControl
import core.ui.SingularityScope
import kotlinx.coroutines.flow.MutableStateFlow

class AuthenticationProtocol : AccessControl<AuthenticationException> {
    private val _fallBack = MutableStateFlow<AuthenticationException?>(null)
    override val fallBack = _fallBack

    override fun invoke(request: () -> SystemResult<*>): SystemResult<*> {
        TODO("Not yet implemented")
    }
}

context(SingularityScope)
@Composable
fun AuthenticationProtocol(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val authentication = remember { AuthenticationProtocol() }

    content.invoke()

    // Fall Back Authentication
    val requireAuthentication by authentication.fallBack.collectAsState()
    if (requireAuthentication != null) {
        LoginPane()
    }
}
