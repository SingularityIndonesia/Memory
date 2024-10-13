package main.service

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import core.adt.getOrElse
import core.model.impl.PhilosopherSophia
import core.ui.designsystem.atom.STextTitle
import org.jetbrains.compose.ui.tooling.preview.Preview

expect val GEMINI_API_KEY: String

val PhilosopherShopia
    get() = PhilosopherSophia(
        geminiApiKey = GEMINI_API_KEY,
        preConfiguration = listOf(
            "You will talking to a user name: Steve",
            "Steve is 29 yo handsome boy",
            "You will speak in ${Locale.current.language}"
        )
    )

@Preview
@Composable
fun PreviewSophiaPreview() {
    val sophia = remember { PhilosopherShopia }
    var conversation by remember { mutableStateOf<List<String>>(listOf()) }
    var isLoading by remember{ mutableStateOf(false) }

    LaunchedEffect(Unit) {
        val input = "Tell me who I am?"
        conversation += "User: $input"
        isLoading = true
        val response = sophia.digest(input).getOrElse { "${it.message}" }
        conversation += "Sophia: $response"
        isLoading = false
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        STextTitle("Sophia Test")
        conversation.map {
            Card {
                Box(modifier = Modifier.padding(16.dp)) {
                    Text(it)
                }
            }
        }

        if (isLoading)
            Card {
                Box(modifier = Modifier.padding(16.dp)) {
                    Text("Loading response ...")
                }
            }
    }
}