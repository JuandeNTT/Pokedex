package com.example.pokedex.presentation.feature.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.pokedex.data.model.getId
import com.example.pokedex.data.model.getImageUrl
import com.example.pokedex.presentation.feature.viewmodel.PokemonViewModel

@Composable
fun PokemonDetailScreen(
    navController: NavController,
    viewModel: PokemonViewModel
) {

    val pokemon = viewModel.selectedPokemon

    if (pokemon == null) {
        Text("No hay Pokémon seleccionado")
        return
    }

    val id = getId(pokemon.url)
    val imageUrl = getImageUrl(id)

    LaunchedEffect(id) {
        viewModel.loadPokemonDetail(id)
    }

    val detail = viewModel.pokemonDetail

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = imageUrl,
                contentDescription = pokemon.name,
                modifier = Modifier.size(180.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "ID: #$id")

            Text(text = pokemon.name.uppercase())

            Spacer(modifier = Modifier.height(20.dp))

            if (detail == null) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                val typesText = detail.types.joinToString { it.type.name }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {

                    Text("Tipo: $typesText")
                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Altura: ${detail.height} dm")
                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Peso: ${detail.weight} g")

                }
            }
        }
        OutlinedButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            border = BorderStroke(1.dp, Color.Red)
        ) {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = "Volver al listado"
        )
        Spacer(Modifier.width(10.dp))
        Text("Volver al listado")
    }
    }
}