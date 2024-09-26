package profile

import core.adt.SystemResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import profile.entity.UserBasicInfo

class ProfileModel {
    suspend fun getUserBasicInfo(): SystemResult<UserBasicInfo> =
        withContext(Dispatchers.Default) {
            TODO()
        }

    suspend fun saveUserBasicInfo(userBasicInfo: UserBasicInfo): SystemResult<UserBasicInfo> =
        withContext(Dispatchers.Default) {
            TODO()
        }
}
