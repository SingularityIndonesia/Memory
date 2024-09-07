package main.protocol

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import core.exception.AuthenticationException
import core.operation.SystemResult
import core.protocol.AccessControl
import core.ui.SingularityScope
import core.ui.designsystem.component.STextTitle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/**
 * See: [access control design layer](/Brain/image/access control design layer.jpg)
 */
class AuthenticationProtocol : AccessControl<AuthenticationException> {
    private val _fallBack = MutableStateFlow<AuthenticationException?>(null)
    override val fallBack = _fallBack

    override suspend fun <T> invoke(request: () -> SystemResult<T>): SystemResult<T> =
        suspendCancellableCoroutine { continuation ->
            val coroutine = CoroutineScope(Dispatchers.IO + SupervisorJob())
            val result = request.invoke()

            if (result is SystemResult.Error && result.e is AuthenticationException) {
                // notify requires protocol interception
                _fallBack.update { result.e as AuthenticationException }

                coroutine.launch {
                    _fallBack.collect { e ->
                        if (e != null) return@collect

                        // retry request by redo the current protocol
                        val newResult = invoke(request)

                        // continue the suspend function
                        continuation.resume(newResult)

                        // cancel job
                        coroutine.cancel()
                    }
                }
            }
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
        STextTitle(
            modifier = modifier,
            text = "Authentication Protocol Interception",
        )
    }
}
