package core.model

import androidx.compose.runtime.Immutable
import core.pattern.SystemLogger

@Immutable
class SystemLogger : SystemLogger {
    override fun log(message: String) {
        println("Singularity Log: $message")
    }
}
