package core

import androidx.compose.runtime.staticCompositionLocalOf
import core.adt.Platform
import core.adt.UnknownPlatform
import core.model.Preference
import core.model.StateSaver
import core.model.SystemLogger
import core.model.dummy.DummyPreference
import core.model.dummy.DummySystemLogger
import core.ui.designsystem.boson.SystemToken

val Platform =
    staticCompositionLocalOf<Platform> {
        UnknownPlatform
    }

@Suppress("DEPRECATION")
val SystemToken =
    staticCompositionLocalOf<SystemToken> {
        SystemToken()
    }

val StateSaver =
    staticCompositionLocalOf<StateSaver> {
        StateSaver
    }

val SystemLogger =
    staticCompositionLocalOf<SystemLogger> {
        DummySystemLogger
    }

val Preference =
    staticCompositionLocalOf<Preference> {
        DummyPreference
    }
