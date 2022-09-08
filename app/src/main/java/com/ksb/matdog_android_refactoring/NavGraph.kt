package com.ksb.matdog_android_refactoring
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//
//
//sealed class Screen(val route: String) {
//    object SettingScreen : Screen("settingScreen")
//    object PushScreen : Screen("pushScreen")
//    object VersionScreen : Screen("versionScreen")
//}
//
//@Composable
//fun AppNavGraph(
//    navController: NavHostController,
//    modifier: Modifier = Modifier
//) {
//    NavHost(
//        modifier = modifier,
//        navController = navController,
//        startDestination = Screen.SettingScreen.route
//    ) {
//        addSetting(navController)
//        addPush(navController)
//        addVersion(navController)
//    }
//}
//
//private fun NavGraphBuilder.addSetting(
//    navController: NavController
//) {
//    composable(Screen.SettingScreen.route) {
//        SettingScreen(
//            navController as NavHostController
//        )
//    }
//}
//
//private fun NavGraphBuilder.addPush(
//    navController: NavController
//) {
//    composable(Screen.PushScreen.route) {
//        PushScreen(
//            navController = navController
//        )
//    }
//}
//
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