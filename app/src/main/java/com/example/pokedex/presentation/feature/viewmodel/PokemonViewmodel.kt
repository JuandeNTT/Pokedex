package com.example.pokedex.presentation.feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.network.RetrofitClient
import com.example.pokedex.presentation.state.PokemonUiState
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private var _uiState by mutableStateOf<PokemonUiState>(PokemonUiState.Loading)
    val uiState: PokemonUiState get() = _uiState

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getPokemonList()
                _uiState = PokemonUiState.Success(response.results)
            } catch (_: Exception) {
                _uiState = PokemonUiState.Error("Error al cargar")
            }
        }
    }
}