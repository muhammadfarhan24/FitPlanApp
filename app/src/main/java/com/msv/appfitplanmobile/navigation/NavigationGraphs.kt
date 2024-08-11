package com.msv.appfitplanmobile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.msv.appfitplanmobile.halaman_pilih.GenderSelectionScreen
import com.msv.appfitplanmobile.halaman_pilih.LevelSelectionScreen
import com.msv.appfitplanmobile.halaman_pilih.MainTargetScreen
import com.msv.appfitplanmobile.halaman_pilih.SuccessScreen
import com.msv.appfitplanmobile.screens.AllNotesScreen
import com.msv.appfitplanmobile.screens.AnalyticsScreen
import com.msv.appfitplanmobile.screens.CalenderScreen
import com.msv.appfitplanmobile.screens.DailyMealsScreen
import com.msv.appfitplanmobile.screens.HomeScreen
import com.msv.appfitplanmobile.screens.NotificationScreen
import com.msv.appfitplanmobile.screens.PlanScreen
import com.msv.appfitplanmobile.screens.ProfileScreen
import com.msv.appfitplanmobile.screens.splash.SplashScreen
import com.msv.appfitplanmobile.screens.TargetProgressScreen
import com.msv.appfitplanmobile.screens.TrainingRecommendationScreen
import com.msv.appfitplanmobile.screens.TrainingScreen
import com.msv.appfitplanmobile.screens.TriviaScreen
import com.msv.appfitplanmobile.screens.boarding.BoardingScreen
import com.msv.appfitplanmobile.screens.body_sample.BodySampleScreen
import com.msv.appfitplanmobile.screens.login.LoginScreen
import com.msv.appfitplanmobile.screens.note_sample.NoteSampleScreen

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController, startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navHostController)
        }
        composable("boarding") {
            BoardingScreen(navHostController)
        }
        composable("login") {
            LoginScreen(navHostController)
        }
        composable("home") {
            HomeScreen(navHostController)
        }
        composable("note_sample"){
            NoteSampleScreen(navHostController)
        }
        composable("body_sample"){
            BodySampleScreen(navController = navHostController)
        }
        composable("gender") {
            GenderSelectionScreen(navController = navHostController)
        }
        composable("target") {
            MainTargetScreen(navController = navHostController)
        }
        composable("next") {
            LevelSelectionScreen(navController = navHostController)
        }
        composable("level") {
            LevelSelectionScreen(navController = navHostController)
        }
        composable("finish") {
            SuccessScreen(navController = navHostController)
        }
        composable("notifications") {
            NotificationScreen(navController = navHostController)
        }
        composable("calendar") {
            CalenderScreen(navController = navHostController)
        }
        composable("all_notes") {
            AllNotesScreen(navController = navHostController)
        }
        composable("training") {
            TrainingScreen(navController = navHostController)
        }
        composable("training_recommendation") {
            TrainingRecommendationScreen(navController = navHostController)
        }
        composable("daily_meals") {
            DailyMealsScreen(navController = navHostController)
        }
        composable("trivia") {
            TriviaScreen(navController = navHostController)
        }
        composable("trivia") {
            TriviaScreen(navController = navHostController)
        }
        composable("analytics") {
            AnalyticsScreen(navController = navHostController)
        }
        composable("target_progres") {
            TargetProgressScreen(navController = navHostController)
        }
        composable("save") {
            AnalyticsScreen(navController = navHostController)
        }
        composable("plan") {
            PlanScreen(navController = navHostController)
        }
        composable("profile") {
            ProfileScreen(navController = navHostController)
        }
    }
}
