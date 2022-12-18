package com.olivierloukombo.android_app_fake_api.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.olivierloukombo.android_app_fake_api.views.Home
import com.olivierloukombo.android_app_fake_api.views.SplashScreen
import com.olivierloukombo.android_app_fake_api.vm.MainViewModel
import javax.inject.Inject


@Composable
fun SetupNavGraph(navController: NavHostController,  viewModel : MainViewModel){
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
           // navController.popBackStack(Screen.SplashScreen.route, true)
            Home(viewModel).Main()
        }
    }

}