package org.sopt.play

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.play.ui.theme.SoptColor
import org.sopt.play.ui.theme.SoptTypography


@Composable
fun TabMenuButton(
    text: String
) {
    TextButton(
        onClick = {},
        contentPadding = PaddingValues(
            horizontal = 16.dp, vertical = 8.dp),

    )
    {
        Text(text=text,
            color= SoptColor.Black,
            style= SoptTypography.m18)
    }
}

@Composable
fun MainTabMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())

    ) {
        TabMenuButton("2배적립")
        TabMenuButton("홈")
        TabMenuButton("셀렉티드")
        TabMenuButton("브랜드")
        TabMenuButton("뷰티")
        TabMenuButton("라이프")
        TabMenuButton("랭킹")
    }
}