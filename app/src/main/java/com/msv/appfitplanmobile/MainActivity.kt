package com.msv.appfitplanmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.navigation.NavigationGraph
import com.msv.appfitplanmobile.ui.theme.AppFitPlanMobileTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFitPlanMobileTheme {
                val navController = rememberNavController()
                NavigationGraph(navHostController = navController)
            }
        }
    }
}