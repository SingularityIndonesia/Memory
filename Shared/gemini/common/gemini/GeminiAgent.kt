package gemini


enum class GeminiModel(val model: String) {
    `gemini-1_5-flash`("gemini-1.5-flash"),
    `gemini-1_5-pro`("gemini-1.5-pro")
}

data class Message(
    val text: String? = null,
    // @OptIn(ExperimentalEncodingApi::class)
    // val image: Base64? = null
)

interface GeminiAgent {
    val geminiModel: GeminiModel
    val geminiApiKey: String
    val defaultPrompt: List<Message>

    suspend fun send(message: Message): Result<Message>
}

expect fun createAgent(
    geminiApiKey: String,
    geminiModel: GeminiModel = GeminiModel.`gemini-1_5-flash`,
    defaultPrompt: List<Message> = emptyList(),
): GeminiAgent