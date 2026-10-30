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
    chip: String,
    isSelected: Boolean,
    onChipClick:(String)-> Unit
) {
    Button(
        onClick = {onChipClick(chip)},
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) SoptColor.Gray5
                else SoptColor.White
        ),
        border = BorderStroke(
                width=1.dp,
                color = if (isSelected) SoptColor.Gray5
                    else SoptColor.Gray2
                ),
        modifier = Modifier,
        contentPadding= PaddingValues(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(text = chip,
            color = if (isSelected) SoptColor.White else SoptColor.Gray5,
            style = SoptTypography.m14,
            maxLines = 1)
    }
}

@Composable
fun HomeCategory(
    selectedChip: String,
    onChipClick: (String) -> Unit
) {
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
            ChipButton("전체", isSelected = selectedChip == "전체", onChipClick = onChipClick)
            ChipButton("상의", isSelected = selectedChip == "상의", onChipClick = onChipClick)
            ChipButton("팬츠", isSelected = selectedChip == "팬츠", onChipClick = onChipClick)
            ChipButton("원피스", isSelected = selectedChip == "원피스", onChipClick = onChipClick)
            ChipButton("아우터", isSelected = selectedChip == "아우터", onChipClick = onChipClick)
            ChipButton("스커트", isSelected = selectedChip == "스커트", onChipClick = onChipClick)
            ChipButton("슈즈", isSelected = selectedChip == "슈즈", onChipClick = onChipClick)
            ChipButton("가방", isSelected = selectedChip == "가방", onChipClick = onChipClick)
            ChipButton("이너웨어/잠옷", isSelected = selectedChip == "이너웨어/잠옷", onChipClick = onChipClick)
            ChipButton("폰꾸미기", isSelected = selectedChip == "폰꾸미기", onChipClick = onChipClick)
        }
    }
}
