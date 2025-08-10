package com.gks.absolutebank.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
  bodyLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 15.sp,
    fontWeight = FontWeight(400),
    lineHeight = 20.sp,
    letterSpacing = 0.5.sp
  ),
  titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight(600),
        fontSize = 17.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    ),
  labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
titleMedium = TextStyle(
  fontFamily = FontFamily.Default,
  fontWeight = FontWeight(600),
  fontSize = 15.sp,
  lineHeight = 20.sp,
  letterSpacing = 0.sp
),
  bodyMedium = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight(400),
    fontSize = 13.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.sp
  ),
  bodySmall = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight(400),
    fontSize = 11.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.sp
  ),
  labelLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight(400),
    fontSize = 10.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.sp
  ),
)