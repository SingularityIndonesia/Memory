package core.example.navigation.composeApp.navigation

import core.navigation.UrlParam
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// # Route2 Route ----------------------------------------------------------------------------------
// put this in composeApp/navigation
@Serializable
data class Feature2Route2Param(
    @SerialName("magicNumber")
    val magicNumber: Int,
) : UrlParam
