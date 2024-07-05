package com.example.gonggoose.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.gonggoose.ui.screen.auth.EnterNickNameScreen
import com.example.gonggoose.ui.screen.auth.LoginScreen
import com.example.gonggoose.ui.screen.auth.SchoolVerificationScreen
import java.util.concurrent.ScheduledExecutorService

sealed class Routes(val route: String) {

    data object Splash : Routes("Splash")
    data object Login : Routes("Login")

    //sign up
    data object EnterNickName : Routes("signup/nickName")
    data object SchoolVerification : Routes("signup/school")

    //home
    data object Home : Routes("home/Home")

}

@SuppressLint("RestrictedApi", "StateFlowValueCalledInComposition")
@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Splash.route) {

        composable(Routes.Login.route) {
            LoginScreen()
        }

        navigation(startDestination = Routes.EnterNickName.route, route = "signup") {
            composable(Routes.EnterNickName.route) {
                EnterNickNameScreen()
            }
            composable(Routes.SchoolVerification.route) {
                SchoolVerificationScreen()
            }
        }

        navigation(startDestination = Routes.EnterNickName.route, route = "home") {
            composable(Routes.Home.route) {

            }
        }
    }

}