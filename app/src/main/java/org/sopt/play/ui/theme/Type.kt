package org.sopt.play.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.sopt.play.R

// Set of Material typography styles to start with
private val Pretendard= FontFamily(
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_semibold, FontWeight.SemiBold),
    Font(R.font.pretendard_bold, FontWeight.Bold)
)

object SoptTypography {

    val m14= TextStyle(
        fontFamily = Pretendard,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 1.2.em,
        letterSpacing = (-0.01).em
    )
    val m18= TextStyle(
        fontFamily = Pretendard,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 1.2.em,
        letterSpacing = (-0.01).em
    )
    val sb14= TextStyle(
        fontFamily = Pretendard,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 1.2.em,
        letterSpacing = (-0.01).em
    )

    val sb16= TextStyle(
        fontFamily = Pretendard,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 1.2.em,
        letterSpacing = (-0.01).em
    )

    val b28= TextStyle(
        fontFamily = Pretendard,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 1.2.em,
        letterSpacing = (-0.01).em
    )



}

val Typography = Typography(
    bodyMedium = SoptTypography.m14,
    bodyLarge = SoptTypography.m18,
    titleSmall = SoptTypography.sb14,
    titleMedium = SoptTypography.sb16,
    headlineLarge = SoptTypography.b28
)