package profile

import core.operation.SystemResult
import profile.entity.UserBasicInfo

class ProfileModel {
    suspend fun getBasicInfo(): SystemResult<UserBasicInfo> = TODO()
}