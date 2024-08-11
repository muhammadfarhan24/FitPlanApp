package com.msv.appfitplanmobile.navigation

import com.msv.appfitplanmobile.R

sealed class BottomBarScreen(val route: String, val icon: Int) {
    object Home : BottomBarScreen("home", R.drawable.ic_home)
    object Calendar : BottomBarScreen("calendar", R.drawable.ic_calendar)
    object Training : BottomBarScreen("training", R.drawable.ic_training)
    object Analytics : BottomBarScreen("analytics", R.drawable.ic_analytics)
    object Profile : BottomBarScreen("profile", R.drawable.ic_user)
}


