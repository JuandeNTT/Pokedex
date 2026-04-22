package com.example.pokedex.data.network

import com.example.pokedex.data.model.PokemonList
import retrofit2.http.GET

interface PokeApiService {
    @GET("pokemon?limit=20&offset=0")
    suspend fun getPokemonList(): PokemonList

}