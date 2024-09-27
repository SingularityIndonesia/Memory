package core.model.impl

import androidx.compose.runtime.Immutable
import core.model.SystemLogger

@Immutable
class SystemLogger : SystemLogger {
    override fun log(message: String) {
        println("Singularity Log: $message")
    }
}
