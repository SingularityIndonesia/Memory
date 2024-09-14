package core.navigation

import kotlinx.serialization.Serializable

interface UrlParam

@Serializable
object UnitParam : UrlParam
