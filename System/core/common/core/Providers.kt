package core

import androidx.compose.runtime.staticCompositionLocalOf
import core.adt.Platform
import core.model.StateSaver
import core.pattern.Preference
import core.pattern.SystemLogger
import core.ui.designsystem.boson.SystemToken

val Platform =
    staticCompositionLocalOf<Platform> {
        error("Platform not provided")
    }

@Suppress("DEPRECATION")
val SystemToken =
    staticCompositionLocalOf<SystemToken> {
        error("SystemToken not provided")
    }

val StateSaver =
    staticCompositionLocalOf<StateSaver> {
        error("StateSaver not provided")
    }

val SystemLogger =
    staticCompositionLocalOf<SystemLogger> {
        error("SystemLogger not provided")
    }

val Preference =
    staticCompositionLocalOf<Preference> {
        error("SystemLogger not provided")
    }
