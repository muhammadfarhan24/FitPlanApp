package com.msv.appfitplanmobile.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.ui.theme.AppFitPlanMobileTheme

@Composable
fun BottomNavigationBarScreen(navController: NavController) {
    var selectedItem by rememberSaveable { mutableStateOf(BottomBarScreen.Home.route) }

    NavigationBar(
        containerColor = Color(0xFF1C1C1E)
    ) {
        val screens = listOf(
            BottomBarScreen.Home,
            BottomBarScreen.Calendar,
            BottomBarScreen.Training,
            BottomBarScreen.Analytics,
            BottomBarScreen.Profile
        )
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                isSelected = selectedItem == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    selectedItem = screen.route
                }
            )
        }
    }

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    LaunchedEffect(currentBackStackEntry) {
        currentBackStackEntry?.destination?.route?.let { route ->
            selectedItem = route
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val indicatorColor by animateColorAsState(targetValue = if (isSelected) Color.White else Color.Transparent)
    val contentColor by animateColorAsState(targetValue = if (isSelected) Color.Black else Color.White)

    NavigationBarItem(
        icon = {
            Icon(
                painterResource(id = screen.icon),
                contentDescription = null,
                tint = contentColor,
                modifier = Modifier.size(20.dp)
            )
        },
        selected = isSelected,
        onClick = onClick,
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = indicatorColor,
            selectedIconColor = contentColor,
            selectedTextColor = contentColor,
            unselectedIconColor = Color.Gray,
            unselectedTextColor = Color.Gray
        )
    )
}


@Preview
@Composable
private fun BottomNavigationBarPreview() {
    AppFitPlanMobileTheme {
        BottomNavigationBarScreen(navController = rememberNavController())
    }
}
