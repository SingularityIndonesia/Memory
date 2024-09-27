package core.model

import androidx.compose.runtime.Immutable

@Immutable
interface SystemLogger {
    fun log(message: String)
}
