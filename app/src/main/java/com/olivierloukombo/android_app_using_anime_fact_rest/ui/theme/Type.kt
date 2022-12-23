package com.olivierloukombo.android_app_using_anime_fact_rest.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.olivierloukombo.android_app_using_anime_fact_rest.R

// Set of Material typography styles to start with
val DmSans = FontFamily(
    Font(R.font.dm_sans_regular),
    Font(R.font.dm_sans_bold, FontWeight.Bold)
)
val colorSecondaryText = Indigo

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = DmSans,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = BrilliantAzure
    ),
    h2 = TextStyle(
        fontFamily = DmSans,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 16.sp,
        color = colorSecondaryText
    ),
    body1 = TextStyle(
        fontFamily = DmSans,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = colorSecondaryText
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)