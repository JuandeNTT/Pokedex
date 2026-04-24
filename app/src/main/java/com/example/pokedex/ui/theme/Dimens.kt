package com.example.pokedex.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.TextUnit

data class Dimens(

    //Padding
    val paddingExtraSmall: Dp = 4.dp,
    val paddingSmall: Dp = 8.dp,
    val paddingMedium: Dp = 16.dp,
    val paddingLarge: Dp = 20.dp,
    val paddingExtraLarge: Dp = 32.dp,

    //Radius
    val borderRadiusSmall: Dp = 1.dp,
    val borderRadiusMedium: Dp = 2.dp,
    val radiusSmall: Dp = 8.dp,
    val radiusMedium: Dp = 12.dp,
    val radiusLarge: Dp = 16.dp,

    //Image sizes
    val pokemonImageSmall: Dp = 80.dp,
    val pokemonImageMedium: Dp = 120.dp,
    val pokemonImageExtraMedium: Dp = 150.dp,
    val pokemonImageLarge: Dp = 180.dp,

    //Icon sizes
    val iconSmall: Dp = 16.dp,
    val iconMedium: Dp = 24.dp,
    val iconLarge: Dp = 32.dp,

    //Elevation
    val elevationSmall: Dp = 4.dp,
    val elevationMedium: Dp = 8.dp,
    val elevationLarge: Dp = 12.dp,

    //Typography
    val textSmall: TextUnit = 14.sp,
    val textMedium: TextUnit = 18.sp,
    val textLarge: TextUnit = 24.sp,
    val textExtraLarge: TextUnit = 30.sp,

    //Letter Spacing
    val letterSpacingSmall: TextUnit = 1.2.sp,
    val letterSpacingMedium: TextUnit = 2.sp,

    //Spacer
    val spacerLarge: Dp = 10.dp,
    val spacerLarge12: Dp = 12.dp,
    val spacerLarge20: Dp = 20.dp
)

val LocalDimens = staticCompositionLocalOf {
    Dimens()
}