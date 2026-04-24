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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex.data.model.PokemonResult
import com.example.pokedex.presentation.components.PokemonItem
import com.example.pokedex.presentation.feature.viewmodel.PokemonViewModel
import com.example.pokedex.ui.theme.LocalDimens

@Composable
fun SuccessScreen(
    pokemons: List<PokemonResult>,
    navController: NavHostController,
    viewModel: PokemonViewModel
) {
    val dimens = LocalDimens.current
    val pageSize = 10
    val pages = pokemons.chunked(pageSize)

    val pagerState = rememberPagerState(
        pageCount = { Int.MAX_VALUE }
    )

    Column {

        val currentPage = (pagerState.currentPage % pages.size) + 1
        val totalPages = pages.size

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.paddingSmall),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Página $currentPage / $totalPages",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color(0xFFEF5350), RoundedCornerShape(dimens.radiusMedium))
                    .padding(horizontal = dimens.paddingMedium, vertical = dimens.paddingSmall)
            )
        }

        HorizontalPager(state = pagerState) { page ->

            val pageIndex = page % pages.size
            val pokemonsList = pages[pageIndex]

            LazyColumn { -> items(pokemonsList) { pokemon ->
                    PokemonItem(pokemon, navController, viewModel)
                }
            }
        }
    }
}