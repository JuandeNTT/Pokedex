package com.example.pokedex.data.model

data class PokemonList(
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)
data class PokemonDetail(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<Types>,
    val sprites: Sprites
)

data class Types(
    val type: Type
)

data class Type(
    val name: String
)

data class Sprites(
    val frontDefault: String
)

fun getId(url: String): Int {
    return url.trimEnd('/').substringAfterLast('/').toInt()
}

fun getImageUrl(id: Int): String {
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
}