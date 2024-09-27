package authentication

import authentication.entity.Authentication
import authentication.entity.Token
import core.adt.SystemResult

interface AuthenticationRepository {
    suspend fun login(): SystemResult<Authentication>

    suspend fun saveToken(token: Token): SystemResult<Token>
}
