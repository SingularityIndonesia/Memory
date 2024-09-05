package authentication

import authentication.entity.Authentication
import core.exception.AuthenticationException
import core.operation.SystemResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import profile.entity.UserBasicInfo

class AuthenticationModel {
    suspend fun login(): SystemResult<Authentication> =
        withContext(Dispatchers.Default) {
            // fixme: dummy
            delay(3000)
            SystemResult.Error(AuthenticationException(Throwable("Fixme: Dummy")))
        }

    suspend fun getUserBasicInfo(): SystemResult<UserBasicInfo> =
        withContext(Dispatchers.Default) {
            TODO()
        }

    internal suspend fun saveUserBasicInfo(userBasicInfo: UserBasicInfo): SystemResult<UserBasicInfo> =
        withContext(Dispatchers.Default) {
            TODO()
        }
}
