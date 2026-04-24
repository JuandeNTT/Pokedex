package com.example.pokedex.presentation.feature.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pokedex.R
import com.example.pokedex.ui.theme.LocalDimens

@Composable
fun ErrorScreen(message: String, onRetry: () -> Unit) {
    val dimens = LocalDimens.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimens.paddingMedium),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            shape = RoundedCornerShape(dimens.radiusLarge),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFEF5350)
            ),

            ) {
            Column(
                modifier = Modifier.padding(dimens.paddingLarge),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(message,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = dimens.paddingSmall),
                    fontWeight = FontWeight.Bold
                )

                OutlinedButton(
                    onClick = {
                        onRetry()
                    },
                    modifier = Modifier
                        .padding(dimens.paddingSmall)
                        .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    border = BorderStroke(dimens.borderRadiusSmall, Color.Red)
                ) {
                    Icon(
                        Icons.Default.Refresh,
                        contentDescription = stringResource(R.string.retry)
                    )
                    Spacer(Modifier.width(dimens.spacerLarge))
                    Text(stringResource(R.string.retry))
                }
            }
        }
    }
}
