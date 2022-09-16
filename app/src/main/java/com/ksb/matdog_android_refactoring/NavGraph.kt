package com.ksb.matdog_android_refactoring

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


sealed class Screen(val route: String) {
    object MainScreen : Screen("MainScreen")
    object CommunityScreen : Screen("CommunityScreen")
    object MyPageScreen : Screen("MyPageScreen")
}

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "main"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("main") {
            MainScreen { navController.navigate("main") }
        }
        composable("mypage") {
            MyPageScreen { navController.navigate("mypage") }
        }
        composable("community") {
            CommunityScreen { navController.navigate("community") }
        }
    }
}


@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        addMain(navController)
        addCommunity(navController)
        addMyPage(navController)
//        addVersion(navController)
    }
}

private fun NavGraphBuilder.addMain(
    navController: NavController
) {
    composable(Screen.MainScreen.route) {
        Screen.MainScreen
    }
}

private fun NavGraphBuilder.addCommunity(
    navController: NavController
) {
    composable(Screen.CommunityScreen.route) {
        Screen.MainScreen
    }
}

private fun NavGraphBuilder.addMyPage(
    navController: NavController
) {
    composable(Screen.MyPageScreen.route) {
        Screen.MyPageScreen
    }
}


//private fun NavGraphBuilder.addVersion(
//    navController: NavController,
//    versionViewModel: UpdateVersionViewModel = UpdateVersionViewModel()
//) {
//    composable(Screen.VersionScreen.route) {
//
//        VersionScreen(
//            navController = navController,
//            currentVersion = versionViewModel.getVersionInformation().second,
//            updateVersion = versionViewModel.getVersionInformation().third
//        )
//
//    }
//}