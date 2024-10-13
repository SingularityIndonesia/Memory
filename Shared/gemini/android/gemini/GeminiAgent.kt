package gemini

import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.*

data class GeminiClient(
    override val geminiApiKey: String,
    override val geminiModel: GeminiModel = GeminiModel.`gemini-1_5-flash`,
    override val defaultPrompt: List<Message> = listOf(),
) : GeminiAgent {
    private val generationConfig: GenerationConfig =
        generationConfig {
            temperature = 1f
            topK = 64
            topP = 0.95f
            maxOutputTokens = 8192
            responseMimeType = "text/plain"
        }

    private val safetySettings: List<SafetySetting> =
        listOf(
            SafetySetting(HarmCategory.HARASSMENT, BlockThreshold.MEDIUM_AND_ABOVE),
            SafetySetting(HarmCategory.HATE_SPEECH, BlockThreshold.MEDIUM_AND_ABOVE),
            SafetySetting(HarmCategory.SEXUALLY_EXPLICIT, BlockThreshold.MEDIUM_AND_ABOVE),
            SafetySetting(HarmCategory.DANGEROUS_CONTENT, BlockThreshold.MEDIUM_AND_ABOVE),
        )

    private val model =
        GenerativeModel(
            geminiModel.model,
            // Retrieve API key as an environmental variable defined in a Build Configuration
            // see https://github.com/google/secrets-gradle-plugin for further instructions
            geminiApiKey,
            generationConfig = generationConfig,
            safetySettings = safetySettings,
        )

    private val chat by lazy {
        model.startChat(
            defaultPrompt.map { it.toContent() },
        )
    }

    override suspend fun send(message: Message): Result<Message> {
        return runCatching {
            val answer = chat.sendMessage(
                message.toContent()
            ).text ?: "Null"
            Message(text = answer)
        }.recover { Message("$it") }
    }
}

actual fun createAgent(
    geminiApiKey: String,
    geminiModel: GeminiModel,
    defaultPrompt: List<Message>,
): GeminiAgent {
    return GeminiClient(
        geminiApiKey = geminiApiKey,
        geminiModel = geminiModel,
        defaultPrompt = defaultPrompt
    )
}