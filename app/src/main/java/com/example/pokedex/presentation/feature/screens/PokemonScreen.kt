package com.example.pokedex.presentation.feature.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pokedex.presentation.feature.viewmodel.PokemonViewModel
import com.example.pokedex.presentation.state.PokemonUiState

@Composable
fun PokemonScreen(
    viewModel: PokemonViewModel = viewModel(),
    navController: NavHostController
) {

    when (val state = viewModel.uiState) {

        PokemonUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        PokemonUiState.Empty -> {
            EmptyScreen()
        }

        is PokemonUiState.Success -> {
            SuccessScreen(state.pokemons, navController, viewModel)
        }

        is PokemonUiState.Error -> {
            ErrorScreen(state.message) { viewModel.loadPokemons() }
        }
    }
}