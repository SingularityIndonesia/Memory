package profile

import core.adt.SystemResult
import profile.entity.UserBasicInfo

class ProfileService : ProfileRepository {
    override suspend fun getUserBasicInfo(): SystemResult<UserBasicInfo> {
        TODO("Not yet implemented")
    }

    override suspend fun saveUserBasicInfo(userBasicInfo: UserBasicInfo): SystemResult<UserBasicInfo> {
        TODO("Not yet implemented")
    }
}
