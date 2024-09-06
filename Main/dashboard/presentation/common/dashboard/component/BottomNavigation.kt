package dashboard.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import system.designsystem.resources.Res
import system.designsystem.resources.logo_of_singularity_indonesia_circle

@Composable
fun BottomNavigation() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Spectrum", "Memories", "Search", "Profile")

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(Res.drawable.logo_of_singularity_indonesia_circle),
                        contentDescription = item,
                    )
                },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
            )
        }
    }
}
