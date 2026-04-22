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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokedex.data.model.PokemonResult
import com.example.pokedex.data.model.extractId
import com.example.pokedex.data.model.getImageUrl

@Composable
fun PokemonItem(pokemon: PokemonResult) {

    val id = extractId(pokemon.url)
    val imageUrl = getImageUrl(id)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
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

            Text(
                text = "ID: #$id",
                style = MaterialTheme.typography.labelMedium
            )

            Text(
                text = pokemon.name.uppercase(),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}