package com.example.pokedex.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    val paddingExtraSmall: Dp = 4.dp,

    )

val LocalDimens = staticCompositionLocalOf {
    Dimens()
}