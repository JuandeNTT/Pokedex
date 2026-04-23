package com.example.pokedex.data.network

import com.example.pokedex.data.model.PokemonDetail
import com.example.pokedex.data.model.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("pokemon?limit=20&offset=0")
    suspend fun getPokemonList(): PokemonList

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: Int): PokemonDetail
}