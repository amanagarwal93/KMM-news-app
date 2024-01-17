package com.example.newsapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.newsapp.R

val poppins = FontFamily(
    fonts = listOf(
        Font(R.font.poppins_regular, FontWeight.Normal),
        Font(R.font.poppins_bold, FontWeight.Bold),
        Font(R.font.poppins_semibold, FontWeight.SemiBold)
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    displaySmall = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 36.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 48.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 21.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 19.sp,
    ),
)