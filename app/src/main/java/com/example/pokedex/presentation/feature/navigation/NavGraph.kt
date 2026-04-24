package com.example.pokedex.presentation.feature.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pokedex.presentation.feature.screens.PokemonDetailScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokedex.presentation.feature.screens.PokemonScreen
import com.example.pokedex.presentation.feature.screens.SplashScreen
import com.example.pokedex.presentation.feature.viewmodel.PokemonViewModel

sealed class ScreenRoutes(
    val route: String
){
    object SplashScreen: ScreenRoutes("splash_screen")
    object PokemonScreen : ScreenRoutes("pokemon_list")
    object PokemonDetailScreen : ScreenRoutes("pokemon_detail")

}

@Composable
fun ScreensNavHost(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    val viewModel: PokemonViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.SplashScreen.route,
        modifier = Modifier.padding(innerPadding),
    ) {

        composable(ScreenRoutes.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(ScreenRoutes.PokemonScreen.route) {
            PokemonScreen(viewModel, navController)
        }

        composable(ScreenRoutes.PokemonDetailScreen.route) {
            PokemonDetailScreen(navController, viewModel)
        }
    }
}