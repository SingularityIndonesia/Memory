package dashboard.pane.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import core.ui.designsystem.component.STextTitle
import dashboard.component.BottomNavigation
import dashboard.pane.discover.DiscoverPane
import dashboard.pane.memories.MemoriesPane
import dashboard.pane.profile.ProfilePane
import dashboard.pane.spectrum.SpectrumPane

@Composable
fun DashboardPane() {
    val selectedTab = remember { mutableIntStateOf(0) }

    Column {
        STextTitle("Dashboard Pane")

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
