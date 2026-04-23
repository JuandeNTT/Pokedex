package com.example.pokedex.presentation.feature.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pokedex.presentation.state.PokemonUiState
import com.example.pokedex.presentation.components.PokemonItem
import com.example.pokedex.presentation.feature.viewmodel.PokemonViewModel


@Composable
fun PokemonScreen(
    viewModel: PokemonViewModel = viewModel(),
    navController: NavHostController
) {

    when (val state = viewModel.uiState) {

        is PokemonUiState.Loading -> {
            CircularProgressIndicator()
        }

        is PokemonUiState.Success -> {
            LazyColumn {
                items(state.pokemons) { pokemon ->
                    PokemonItem(pokemon, navController, viewModel)
                }
            }
        }

        is PokemonUiState.Error -> {
            Text(state.message, color = Color.Red)
        }
    }
}