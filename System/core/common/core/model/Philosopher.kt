package core.model

import androidx.compose.ui.graphics.painter.Painter
import core.adt.SystemResult

interface Philosopher {
    val philosopherName: String
    val philoshoperPhoto: Painter?
    val preConfiguration: List<String>

    suspend fun digest(message: String): SystemResult<String>
}