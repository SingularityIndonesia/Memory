package authentication.modal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.SystemToken
import core.ui.designsystem.atom.SLargeSpacing
import core.ui.designsystem.atom.SPrimaryButton
import core.ui.designsystem.atom.SSmallIcon
import core.ui.designsystem.atom.STextLabel
import core.ui.designsystem.boson.`large-padding`
import core.ui.designsystem.boson.`medium-spacing`
import core.ui.designsystem.boson.`on-primary`
import org.jetbrains.compose.resources.painterResource
import system.designsystem.resources.Res
import system.designsystem.resources.logo_of_singularity_indonesia_circle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBottomSheet(
    showLoading: Boolean = false,
    onLogin: () -> Unit,
    onDismissRequest: () -> Unit,
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
    ) {
        Column {
            LoginWithGoogleButton(showLoading = showLoading, onLogin = onLogin)
            SLargeSpacing()
        }
    }
}

@Composable
fun LoginWithGoogleButton(
    showLoading: Boolean,
    onLogin: () -> Unit,
) {
    val attr = SystemToken.current

    SPrimaryButton(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = attr.`large-padding`),
        onClick = onLogin,
    ) {
        if (showLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                trackColor = attr.`on-primary`,
            )
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(attr.`medium-spacing`),
            ) {
                STextLabel("Login With Google")
                SSmallIcon(
                    painter = painterResource(Res.drawable.logo_of_singularity_indonesia_circle),
                    contentDescription = null,
                )
            }
        }
    }
}
