package authentication

import authentication.entity.Authentication
import core.exception.AuthenticationException
import core.operation.SystemResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class AuthenticationModel {
    suspend fun login(): SystemResult<Authentication> =
        withContext(Dispatchers.Default) {
            // fixme: dummy
            delay(3000)
            SystemResult.Error(AuthenticationException(Throwable("Fixme: Dummy")))
        }
}
