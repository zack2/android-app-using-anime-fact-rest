package com.olivierloukombo.android_app_using_anime_fact_rest.navigation

sealed class Screen(val route: String){
    object SplashScreen : Screen("SplashScreen")
    object Main : Screen("Main")
    object Detail : Screen("Detail")
}
