@file:Suppress("DEPRECATION")

package com.olivierloukombo.android_app_using_anime_fact_rest.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.olivierloukombo.android_app_using_anime_fact_rest.views.DetailAnime
import com.olivierloukombo.android_app_using_anime_fact_rest.views.ListAnime
import com.olivierloukombo.android_app_using_anime_fact_rest.views.SplashScreen
import com.olivierloukombo.android_app_using_anime_fact_rest.vm.DetailViewModel
import com.olivierloukombo.android_app_using_anime_fact_rest.vm.MainViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.olivierloukombo.android_app_using_anime_fact_rest.model.Anime
import com.olivierloukombo.android_app_using_anime_fact_rest.utils.AnimeNavType


//@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Main.route
        ){
              val viewModel : MainViewModel = hiltViewModel()
            ListAnime(navController,viewModel)
        }
        composable(route = Screen.Detail.route+"?anime={anime}",
            arguments = listOf(navArgument("anime") { type = AnimeNavType() })
        ) {
            val viewModel : DetailViewModel = hiltViewModel()
            /*var anime: Anime
            if(Build.VERSION.SDK_INT > 32)
                anime = it.arguments?.getParcelable("anime", Anime::class.java)!!
             anime = it.arguments?.getParcelable("anime")!!*/

            DetailAnime(navController,viewModel)
        }
    }

}