package core.navigation

import kotlinx.serialization.Serializable

interface NavigationResult

@Serializable
object UnitResult : NavigationResult
