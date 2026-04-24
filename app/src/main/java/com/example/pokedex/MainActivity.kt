package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.pokedex.ui.theme.PokedexTheme
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.presentation.feature.navigation.ScreensNavHost

//Realizado por Juan de Dios Panches. Ejercicio 1 sin IA.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScreensNavHost(navController, innerPadding)
                }
            }
        }
    }
}
