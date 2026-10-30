package org.sopt.play

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.play.ui.theme.SoptColor
import org.sopt.play.ui.theme.SoptTypography

@Composable
fun ChipButton(
    text: String
) {
    Button(
        onClick = {},
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = SoptColor.White,
        ),
        border = BorderStroke(
                width=1.dp,
                color = SoptColor.Gray2
                ),
        modifier = Modifier,
        contentPadding= PaddingValues(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(text = text,
            color = SoptColor.Gray5,
            style = SoptTypography.m14,
            maxLines = 1)
    }
}

@Composable
fun HomeCategory() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 20.dp
            )
    ) {
        Text("신효정님을 위한 추천 아이템")

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            ChipButton("전체")
            ChipButton("상의")
            ChipButton("팬츠")
            ChipButton("원피스")
            ChipButton("아우터")
            ChipButton("스커트")
            ChipButton("슈즈")
            ChipButton("가방")
            ChipButton("이너웨어/잠옷")
            ChipButton("폰꾸미기")
        }
    }
}
