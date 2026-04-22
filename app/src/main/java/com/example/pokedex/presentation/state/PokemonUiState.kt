package com.example.pokedex.presentation.state

import com.example.pokedex.data.model.PokemonResult

sealed class PokemonUiState {
    object Loading : PokemonUiState()
    data class Success(val pokemons: List<PokemonResult> = emptyList()) : PokemonUiState()
    data class Error(val message: String) : PokemonUiState()
}