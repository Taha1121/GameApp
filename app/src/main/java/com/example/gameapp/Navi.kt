package com.example.gameapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

//Setup navigation between different pages
@Composable
fun Navigate(navCont: NavHostController) {
    NavHost(navController = navCont, startDestination = "splash") {
        composable("splash") { SplashScreen(navCont) }
        composable("loginRegister") { LoginRegisterScreen(navCont) }
        composable("registerPage") { RegisterPage(navCont) }
        composable("loginPage") { LoginPage(navCont) }
        composable("welcomePage") { Welcome(navCont) }
        composable("gameRules") { GameRules(navCont) }
        composable("gameCenter") { GameCenter(navCont) }

    }
}