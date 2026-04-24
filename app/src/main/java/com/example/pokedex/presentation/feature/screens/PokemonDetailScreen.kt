package com.example.pokedex.presentation.feature.screens

import android.R
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.pokedex.data.model.getId
import com.example.pokedex.data.model.getImageUrl
import com.example.pokedex.presentation.feature.viewmodel.PokemonViewModel
import com.example.pokedex.ui.theme.LocalDimens

@Composable
fun PokemonDetailScreen(
    navController: NavController,
    viewModel: PokemonViewModel
) {
    val dimens = LocalDimens.current
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
            .padding(dimens.paddingMedium),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(dimens.paddingLarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = Modifier.size(dimens.pokemonImageLarge),
                border = BorderStroke(dimens.borderRadiusMedium, Color.LightGray),
                shape = CardDefaults.shape,
                elevation = CardDefaults.cardElevation(20.dp)
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = pokemon.name,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(dimens.spacerLarge12))

            Text(
                text = "ID: #$id",
                color = Color.Gray,
                fontSize = dimens.textMedium,
                letterSpacing = dimens.letterSpacingSmall
            )

            Text(
                text = pokemon.name.uppercase(),
                fontSize = dimens.textExtraLarge,
                fontWeight = androidx.compose.ui.text.font.FontWeight.ExtraBold,
                letterSpacing = dimens.letterSpacingMedium
            )
            Spacer(modifier = Modifier.height(dimens.spacerLarge20))

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

                    Text(
                        text = "TIPO",
                        fontSize = dimens.textSmall,
                        color = Color.Gray,
                        letterSpacing = dimens.letterSpacingSmall
                    )

                    Text(
                        text = typesText.uppercase(),
                        fontSize = dimens.textMedium,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
                        color = Color(0xFF1E1E1E)
                    )

                    Spacer(modifier = Modifier.height(dimens.spacerLarge12))

                    Text(
                        text = "ALTURA",
                        fontSize = dimens.textMedium,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        color = Color.Gray,
                        letterSpacing = dimens.letterSpacingMedium
                    )

                    Text(
                        text = "${detail.height} dm",
                        fontSize = dimens.textMedium,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(dimens.spacerLarge12))

                    Text(
                        text = "PESO",
                        fontSize = dimens.textSmall,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        color = Color.Gray,
                        letterSpacing = dimens.letterSpacingMedium
                    )

                    Text(
                        text = "${detail.weight} g",
                        fontSize = dimens.textMedium,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Medium
                    )
                }
            }
        }
        OutlinedButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .padding(dimens.paddingMedium)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            border = BorderStroke(dimens.borderRadiusSmall, Color.Red)
        ) {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = "Volver al listado"
        )
        Spacer(Modifier.width(dimens.borderRadiusSmall))
        Text("Volver al listado")
    }
    }
}