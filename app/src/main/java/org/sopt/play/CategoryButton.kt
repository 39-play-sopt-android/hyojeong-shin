package org.sopt.play

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.play.ui.theme.SoptColor
import org.sopt.play.ui.theme.SoptTypography

@Composable
fun CategoryButton(
    text: String
) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = SoptColor.White
        ),
        modifier = Modifier,
        contentPadding= PaddingValues(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(text = text, color = SoptColor.Gray5, style = SoptTypography.m14)
    }
}