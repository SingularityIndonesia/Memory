package authentication

import authentication.entity.Authentication
import authentication.entity.Token
import core.adt.SystemResult

class AuthenticationService : AuthenticationRepository {
    override suspend fun login(): SystemResult<Authentication> {
        TODO("Not yet implemented")
    }

    override suspend fun saveToken(token: Token): SystemResult<Token> {
        TODO("Not yet implemented")
    }
}
