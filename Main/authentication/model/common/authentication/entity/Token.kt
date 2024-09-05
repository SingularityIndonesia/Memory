package authentication.entity

import kotlinx.datetime.LocalDateTime

data class Token(
    val token: String,
    val refreshToken: String,
    val validUntilDate: LocalDateTime
)