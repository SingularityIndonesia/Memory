package authentication

import authentication.entity.Authentication
import authentication.entity.Token
import core.adt.AuthenticationException
import core.adt.IOException
import core.adt.SystemResult
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

    suspend fun saveToken(token: Token): SystemResult<Token> =
        withContext(Dispatchers.Default) {
            // fixme: dummy
            delay(3000)
            SystemResult.Error(IOException(Throwable("Fixme: Dummy")))
        }
}
