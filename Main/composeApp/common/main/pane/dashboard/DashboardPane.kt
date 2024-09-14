package main.pane.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import core.ui.SingularityScope
import core.ui.designsystem.atom.SSmallCard
import core.ui.designsystem.atom.SSmallIcon
import core.ui.designsystem.atom.SSmallSpacing
import core.ui.designsystem.atom.STextTitle
import core.ui.designsystem.boson.DesignToken
import core.ui.designsystem.boson.`small-padding`
import core.ui.designsystem.boson.`small-spacing`
import core.ui.designsystem.molecule.SHeader
import discover.pane.discover.DiscoverPane
import kotlinx.coroutines.launch
import main.pane.component.BottomNavigation
import memories.pane.memories.MemoriesPane
import memories.pane.spectrum.SpectrumPane
import org.jetbrains.compose.resources.painterResource
import profile.pane.profile.ProfilePane
import system.designsystem.resources.Res
import system.designsystem.resources.ic_home_fill
import system.designsystem.resources.ic_keyboard_double_arrow_left
import system.designsystem.resources.ic_keyboard_double_arrow_right

context(SingularityScope)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DashboardPane() {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 1, pageCount = { 3 })
    val selectedTab = remember { mutableIntStateOf(0) }

    val backToDashboard =
        remember(pagerState) {
            {
                scope.launch {
                    pagerState.animateScrollToPage(1)
                }
                Unit
            }
        }

    HorizontalPager(
        state = pagerState,
    ) { page ->
        if (page == 0) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                PageHeader(
                    titleText = "Journal",
                    backDirection = BackDirection.Right,
                    onBackToDashboard = backToDashboard,
                )

                // Journal
                Box(
                    modifier = Modifier.weight(1f),
                ) {
                    STextTitle("Journal")
                }
            }
        }

        if (page == 1) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
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

        if (page == 2) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                PageHeader(
                    titleText = "Timeline",
                    backDirection = BackDirection.Left,
                    onBackToDashboard = backToDashboard,
                )

                // Journal
                Box(
                    modifier = Modifier.weight(1f),
                ) {
                    STextTitle("Timeline")
                }
            }
        }
    }
}

private sealed class BackDirection {
    data object Right : BackDirection()

    data object Left : BackDirection()
}

context(SingularityScope)
@Composable
private fun PageHeader(
    titleText: String,
    backDirection: BackDirection,
    onBackToDashboard: () -> Unit,
) {
    val attr = DesignToken.current
    when (backDirection) {
        BackDirection.Left -> {
            SHeader(
                title = {
                    STextTitle(titleText)
                },
                leadingIcon = {
                    SSmallSpacing()
                    SSmallCard(
                        onClick = onBackToDashboard,
                        colors =
                            CardDefaults.cardColors(
                                containerColor = Color.Transparent,
                            ),
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = attr.`small-padding`),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(attr.`small-spacing`),
                        ) {
                            SSmallIcon(
                                painter = painterResource(Res.drawable.ic_keyboard_double_arrow_left),
                                contentDescription = null,
                            )
                            SSmallIcon(
                                painter = painterResource(Res.drawable.ic_home_fill),
                                contentDescription = null,
                            )
                        }
                    }
                },
            )
        }

        BackDirection.Right -> {
            SHeader(
                title = {
                    STextTitle(titleText)
                },
                trailingIcon = {
                    SSmallCard(
                        onClick = onBackToDashboard,
                        colors =
                            CardDefaults.cardColors(
                                containerColor = Color.Transparent,
                            ),
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = attr.`small-padding`),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(attr.`small-spacing`),
                        ) {
                            SSmallIcon(
                                painter = painterResource(Res.drawable.ic_home_fill),
                                contentDescription = null,
                            )
                            SSmallIcon(
                                painter = painterResource(Res.drawable.ic_keyboard_double_arrow_right),
                                contentDescription = null,
                            )
                        }
                    }

                    SSmallSpacing()
                },
            )
        }
    }
}
