package dashboard.pane.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.ui.designsystem.component.STextTitle
import dashboard.component.BottomNavigation
import dashboard.pane.home.HomePane

@Composable
fun DashboardPane() {
    Column {
        STextTitle("Dashboard Pane")
        HomePane(modifier = Modifier.weight(1f))
        BottomNavigation()
    }
}
