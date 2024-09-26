package core.adt

sealed interface Platform {
    val name: String
}

data class IOSPlatform(
    override val name: String,
) : Platform

data class AndroidPlatform(
    override val name: String,
) : Platform

data class WebPlatform(
    override val name: String,
) : Platform

data object UnknownPlatform : Platform {
    override val name: String = "Unknown"
}
