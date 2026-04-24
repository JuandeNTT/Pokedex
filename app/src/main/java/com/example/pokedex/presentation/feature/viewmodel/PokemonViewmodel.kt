package com.example.pokedex.presentation.feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.model.PokemonDetail
import com.example.pokedex.data.model.PokemonResult
import com.example.pokedex.data.network.RetrofitClient
import com.example.pokedex.presentation.state.PokemonUiState
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private var _uiState by mutableStateOf<PokemonUiState>(PokemonUiState.Loading)
    val uiState: PokemonUiState get() = _uiState

    var selectedPokemon: PokemonResult? = null
    private var _pokemonDetail by mutableStateOf<PokemonDetail?>(null)
    val pokemonDetail: PokemonDetail? get() = _pokemonDetail

    init {
        loadPokemons()
    }

    fun loadPokemons() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getPokemonList()
                _uiState = if (response.results.isEmpty()) {
                    PokemonUiState.Empty
                } else {
                    PokemonUiState.Success(response.results)
                }
            } catch (_: Exception) {
                _uiState = PokemonUiState.Error("Error al cargar Pokédex")
            }
        }
    }

    fun loadPokemonDetail(id: Int) {
        viewModelScope.launch {
            try {
                _pokemonDetail =
                    RetrofitClient.instance.getPokemonDetail(id)
            } catch (_: Exception) {
                _pokemonDetail = null
            }
        }
    }
}