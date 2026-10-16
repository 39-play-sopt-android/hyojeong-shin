package org.sopt.play



import android.R.attr.onClick
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import org.sopt.play.ui.theme.SoptColor
import org.sopt.play.ui.theme.SoptTypography
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun TabMenuButton(
    text: String
) {
    TextButton(
        onClick = {},
        contentPadding = PaddingValues(
            horizontal = 16.dp, vertical = 8.dp)
    )
    {
        Text(text=text,
            color= SoptColor.Black,
            style= SoptTypography.m14)
    }
}