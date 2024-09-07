package main.pane.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import discover.pane.discover.DiscoverPane
import main.pane.component.BottomNavigation
import memories.pane.memories.MemoriesPane
import memories.pane.spectrum.SpectrumPane
import profile.pane.profile.ProfilePane

@Composable
fun DashboardPane() {
    val selectedTab = remember { mutableIntStateOf(0) }

    Column {
        when (selectedTab.value) {
            1 -> MemoriesPane(modifier = Modifier.weight(1f))
            2 -> DiscoverPane(modifier = Modifier.weight(1f))
            3 -> ProfilePane(modifier = Modifier.weight(1f))
            else -> SpectrumPane(modifier = Modifier.weight(1f))
        }

        BottomNavigation(
            selectedTab = selectedTab.value,
            onTabSelected = { selectedTab.value = it },
        )
    }
}
