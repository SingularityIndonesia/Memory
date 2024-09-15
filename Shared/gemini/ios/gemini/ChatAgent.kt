package gemini

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

actual fun createAgent(
    geminiApiKey: String,
    modelName: String,
    defaultPrompt: List<String>,
): GeminiAgent =
    object : GeminiAgent {
        override suspend fun sendMessage(message: String): Result<String> =
            withContext(Dispatchers.Default) {
                TODO("Ios is not yet supported")
            }
    }
