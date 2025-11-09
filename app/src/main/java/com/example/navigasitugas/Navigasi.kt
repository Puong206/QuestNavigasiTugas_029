package com.example.navigasitugas

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

enum class Navigasi {
    LandingPage,
    Dashboard,
    Formulir
}

@Composable
fun App(
    navController: NavHostController = rememberNavController()
){

}