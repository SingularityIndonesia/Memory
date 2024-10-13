package gemini

import com.google.ai.client.generativeai.type.Content
import com.google.ai.client.generativeai.type.content

fun Message.toContent(role: String = "user"): Content {
    return content(role) {
        text?.let { t -> text(t) }
        // image?.let { TODO() }
    }
}