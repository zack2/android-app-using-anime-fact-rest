package com.olivierloukombo.android_app_using_anime_fact_rest.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = BrilliantAzure,
    primaryVariant = MaastrichtBlue,
    secondary = Water
)

private val LightColorPalette = lightColors(
    primary = BrilliantAzure,
    primaryVariant = Indigo,
    secondary = MaastrichtBlue,
    background = BlueStarlight,
    onSecondary = Water,
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)


@Composable
fun AndroidappusinganimefactrestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}