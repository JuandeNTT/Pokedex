package com.example.pokedex.presentation.feature.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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

            Column {

                val currentPage = (pagerState.currentPage % pages.size) + 1
                val totalPages = pages.size

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Página $currentPage / $totalPages",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .background(Color(0xFFEF5350), RoundedCornerShape(12.dp))
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }

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
        }

        is PokemonUiState.Error -> {
            Text(state.message, color = Color.Red)
        }
    }
}