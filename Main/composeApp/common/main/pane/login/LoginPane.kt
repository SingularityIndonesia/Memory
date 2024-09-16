package main.pane.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mmk.kmpauth.firebase.google.GoogleButtonUiContainerFirebase
import com.mmk.kmpauth.uihelper.google.GoogleSignInButton
import core.ui.SingularityScope

/**
 * Created by: Muhammad Jafar
 * At: 16.09.24
 * Find me: 131.powerfull@gmail.com
 */

data class LoginPaneState(
    val isAuthReady: Boolean = false,
    val token: String = ""
)

context(SingularityScope)
@Composable
fun LoginPane(
    viewModel: LoginPaneViewModel
) {
    val state by viewModel.container.stateFlow.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .padding(bottom = 16.dp),
            text = state.token,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )

        if (state.isAuthReady) {
            GoogleButtonUiContainerFirebase(
                onResult = { firebaseUser ->
                    firebaseUser
                        .onSuccess {
                            viewModel.saveToken(it?.uid ?: "Null")
                            log(it?.uid ?: "Null log")
                        }
                        .onFailure {
                            log(it.message ?: "Unknown error")
                        }
                }
            ) {
                GoogleSignInButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    fontSize = 19.sp
                ) { this.onClick() }
            }
        }
    }
}
