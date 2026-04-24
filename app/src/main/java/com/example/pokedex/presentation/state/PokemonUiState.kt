package com.example.pokedex.presentation.state

import com.example.pokedex.data.model.PokemonResult

sealed class PokemonUiState {
    object Loading : PokemonUiState()
    object Empty : PokemonUiState()
    data class Success(val pokemons: List<PokemonResult>) : PokemonUiState()
    data class Error(val message: String) : PokemonUiState()
}