package org.sopt.play

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun CategoryButton(
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
            .height(115.dp)
            .padding(
                horizontal = 16.dp,
                vertical = 20.dp
            ),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("신효정님을 위한 추천 아이템")

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            CategoryButton("전체")
            CategoryButton("상의")
            CategoryButton("팬츠")
            CategoryButton("원피스")
            CategoryButton("아우터")
            CategoryButton("스커트")
            CategoryButton("슈즈")
            CategoryButton("가방")
            CategoryButton("이너웨어/잠옷")
            CategoryButton("폰꾸미기")
        }
    }
}