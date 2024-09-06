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
import system.designsystem.resources.ic_favorite
import system.designsystem.resources.ic_favorite_fill
import system.designsystem.resources.ic_looks
import system.designsystem.resources.ic_looks_fill
import system.designsystem.resources.ic_person
import system.designsystem.resources.ic_person_fill
import system.designsystem.resources.ic_search
import system.designsystem.resources.ic_search_fill

@Composable
fun BottomNavigation() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items =
        listOf(
            "Spectrum" to Res.drawable.ic_looks to Res.drawable.ic_looks_fill,
            "Memories" to Res.drawable.ic_favorite to Res.drawable.ic_favorite_fill,
            "Search" to Res.drawable.ic_search to Res.drawable.ic_search_fill,
            "Profile" to Res.drawable.ic_person to Res.drawable.ic_person_fill,
        )

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(if (index == selectedItem) item.second else item.first.second),
                        contentDescription = item.first.first,
                    )
                },
                label = { Text(item.first.first) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
            )
        }
    }
}
