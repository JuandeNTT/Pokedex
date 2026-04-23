package com.example.pokedex.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.pokedex.data.model.PokemonResult
import com.example.pokedex.data.model.getId
import com.example.pokedex.data.model.getImageUrl
import com.example.pokedex.presentation.feature.viewmodel.PokemonViewModel

@Composable
fun PokemonItem(
    pokemon: PokemonResult,
    navController: NavController,
    viewModel: PokemonViewModel
) {

    val id = getId(pokemon.url)
    val imageUrl = getImageUrl(id)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        onClick = {
            viewModel.selectedPokemon = pokemon
            navController.navigate("pokemon_detail")
        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = pokemon.name,
                modifier = Modifier.size(120.dp)
            )

            Text(text = "ID: #$id")
            Text(text = pokemon.name.uppercase())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonItemPreview() {
    MaterialTheme {
        PokemonItem(
            pokemon = PokemonResult("Charmander", "https://pokeapi.co/api/v2/pokemon/4/"),
            navController = TODO(),
            viewModel = TODO()
        )
    }
}