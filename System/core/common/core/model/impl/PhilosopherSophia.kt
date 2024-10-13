package core.model.impl

import androidx.compose.ui.graphics.painter.Painter
import core.adt.SystemResult
import core.adt.lift
import core.model.Philosopher
import gemini.GeminiAgent
import gemini.GeminiModel
import gemini.Message
import gemini.createAgent

data class PhilosopherSophia(
    private val geminiApiKey: String,
    override val preConfiguration: List<String>
) : Philosopher {
    override val philosopherName: String = "Sophia"
    override val philoshoperPhoto: Painter? = null
    private val geminiAgent: GeminiAgent = createAgent(
        geminiApiKey = geminiApiKey,
        geminiModel = GeminiModel.`gemini-1_5-flash`,
        defaultPrompt = preConfiguration.map { Message(it) }
    )

    override suspend fun digest(message: String): SystemResult<String> {
        return geminiAgent
            .send(Message(message))
            .map {it.text ?: ""}
            .lift()
    }
}