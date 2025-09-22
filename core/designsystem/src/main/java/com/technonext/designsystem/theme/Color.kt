package com.technonext.designsystem.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val ColorPrimaryDark = Color(0xFF005DFF)
val ColorPrimaryLight = Color(0xFFE0EBFF)
val ColorTextPrimary = Color(0xff021561)
val ColorTextSecondary = Color(0xff606888)

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val appBrush = Brush.verticalGradient(
    colors = listOf(
        Color.White.copy(alpha = 0.9f), // 40%
        Color(0xFFF9F9F9)  // 10%
    )
)
val BACKGROUND_COLOR = Color(0xFFF9F9F9)//#F9F9F9

val darkColor1 = Color(0xFF191C21)//#191C21
val darkColor2 = Color(0xFF212833)//#212833
val grayScale = Color(0xFF4E5D78)//#4E5D78
val primaryBlue = Color(0xFF377DFF)//#377DFF
val primaryGreen = Color(0xFF38CB89)//#38CB89
val primaryYellow = Color(0xFFFFAB00)//#FFAB00
val primaryRed = Color(0xFFFF5630)//#FF5630

val ColorError = Color(0xFFFF0000)
val ColorSuccess = Color(0xFF7EBA1D)