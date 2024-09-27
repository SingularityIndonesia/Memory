package profile

import core.adt.SystemResult
import profile.entity.UserBasicInfo

interface ProfileRepository {
    suspend fun getUserBasicInfo(): SystemResult<UserBasicInfo>

    suspend fun saveUserBasicInfo(userBasicInfo: UserBasicInfo): SystemResult<UserBasicInfo>
}
