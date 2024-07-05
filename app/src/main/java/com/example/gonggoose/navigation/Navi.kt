package com.example.gonggoose.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.gonggoose.ui.screen.CreatePostScreen
import com.example.gonggoose.ui.screen.DetailPostScreen
import com.example.gonggoose.ui.screen.HomeScreen

sealed class Routes(val route: String) {

    data object Splash : Routes("Splash")
    data object Login : Routes("Login")

    //sign up
    data object EnterNickName : Routes("signup/nickName")
    data object SchoolVerification : Routes("signup/school")

    //home
    data object Home : Routes("home/Home")
    data object Chatting : Routes("home/Chatting")
    data object MyPage : Routes("home/MyPage")

    //create post
    data object CreatePost : Routes("CreatePost")

    //detail post
    data object DetailPost : Routes("DetailPost")

}

@Composable
fun rememberViewModelStoreOwner(): ViewModelStoreOwner {
    val context = LocalContext.current
    return remember(context) { context as ViewModelStoreOwner }
}

val LocalNavGraphViewModelStoreOwner = staticCompositionLocalOf<ViewModelStoreOwner> {
    error("Undefined ViewModelStoreOwner")
}


@SuppressLint("RestrictedApi", "StateFlowValueCalledInComposition")
@Composable
fun NavGraph(navController: NavHostController) {
    val navStoreOwner = rememberViewModelStoreOwner()

    CompositionLocalProvider(
        LocalNavGraphViewModelStoreOwner provides navStoreOwner
    ) {
        NavHost(navController = navController, startDestination = Routes.Home.route) {

            composable(Routes.Login.route) {

            }

            navigation(startDestination = Routes.EnterNickName.route, route = "signup") {
                composable(Routes.EnterNickName.route) {

                }
                composable(Routes.SchoolVerification.route) {

                }
            }

            navigation(startDestination = Routes.Home.route, route = "home") {
                composable(Routes.Home.route) {
                    HomeScreen(navController)
                }
            }
            composable(Routes.Home.route) {
                HomeScreen(navController)
            }

            composable(Routes.CreatePost.route) {
                CreatePostScreen(navController)
            }

            composable(Routes.DetailPost.route + "?postid={postId}",
                arguments = listOf(
                    navArgument(name = "postId")
                    {
                        type = NavType.LongType }
                )
            ) {
                it.arguments?.getLong("postId")
                    ?.let { it1 -> DetailPostScreen(navController = navController, postId = it1) }
            }
        }
    }

}