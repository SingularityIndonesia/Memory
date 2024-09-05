package profile.entity

import kotlinx.datetime.LocalDateTime

data class UserBasicInfo(
    val fullName: String,
    val userName: String,
    val email: String,
    val age: Int,
    val bornDate: LocalDateTime,
    val profilePictureUrl: String,
    val sex: Sex,
)

enum class Sex {
    MALE, FEMALE, HERMAPHROD
}