package core.pattern

import androidx.compose.runtime.Immutable

@Immutable
interface SystemLogger {
    fun log(message: String)
}

object DummyLogger : SystemLogger {
    override fun log(message: String) {}
}
