package authentication.entity

import profile.entity.UserBasicInfo

data class Authentication(
    val user: UserBasicInfo,
    val token: Token
)