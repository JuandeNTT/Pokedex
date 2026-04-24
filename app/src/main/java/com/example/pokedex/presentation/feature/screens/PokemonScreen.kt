package com.example.pokedex.presentation.feature.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
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

            val pageSize = 10
            val pages = state.pokemons.chunked(pageSize)

            val pagerState = rememberPagerState(
                pageCount = { Int.MAX_VALUE }
            )

            HorizontalPager(state = pagerState) { page ->

                val pageIndex = page % pages.size
                val pokemonsList = pages[pageIndex]

                LazyColumn {
                    items(pokemonsList) { pokemon ->
                        PokemonItem(pokemon, navController, viewModel)
                    }
                }
            }
        }

        is PokemonUiState.Error -> {
            Text(state.message, color = Color.Red)
        }
    }
}