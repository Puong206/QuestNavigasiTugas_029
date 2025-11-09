package com.example.navigasitugas

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasitugas.view.Dashboard
import com.example.navigasitugas.view.Formulir
import com.example.navigasitugas.view.LandingPage

enum class Navigasi {
    Start,
    Home,
    Add
}

@Composable
fun App(
    navController: NavHostController = rememberNavController()
){
    Scaffold { frame1 ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Start.name,
            modifier = Modifier.padding(frame1))
        {
            composable(route = Navigasi.Start.name) {
                LandingPage(
                    onStartButtonClick = { navController.navigate(Navigasi.Home.name)}
                )
            }
            composable(route = Navigasi.Home.name) {
                Dashboard(
                    onExitButtonClick = { cancelAndBackToStart(navController) },
                    onFormButtonClick = { navController.navigate(Navigasi.Add.name) }
                )
            }
            composable(route = Navigasi.Add.name) {
                Formulir(
                    onBackButtonClick = { backToHome(navController) },
                    onSubmitButtonClick = {},
                    onResetButtonClick = {}
                )
            }
        }
    }
}

private fun cancelAndBackToStart(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.Start.name, inclusive = false)
}

private fun backToHome(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.Home.name, inclusive = false)
}