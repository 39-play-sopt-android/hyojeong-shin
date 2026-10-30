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
    menu: String,
    isSelected: Boolean,
    onMenuClick:(String)-> Unit
) {
    TextButton(
        onClick = {onMenuClick(menu)},
        contentPadding = PaddingValues(
            horizontal = 16.dp, vertical = 8.dp),

    )
    {
        Text(text=menu,
            color= if (isSelected) SoptColor.Black
            else SoptColor.Gray3,
            style= SoptTypography.m18)
    }
}

@Composable
fun MainTabMenu(
    selectedMenu: String,
    onMenuClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())

    ) {
        TabMenuButton("2배적립", isSelected = selectedMenu == "2배적립", onMenuClick = onMenuClick)
        TabMenuButton("홈", isSelected = selectedMenu == "홈", onMenuClick = onMenuClick)
        TabMenuButton("셀렉티드", isSelected = selectedMenu == "셀렉티드", onMenuClick = onMenuClick)
        TabMenuButton("브랜드", isSelected = selectedMenu == "브랜드", onMenuClick = onMenuClick)
        TabMenuButton("뷰티", isSelected = selectedMenu == "뷰티", onMenuClick = onMenuClick)
        TabMenuButton("라이프", isSelected = selectedMenu == "라이프", onMenuClick = onMenuClick)
        TabMenuButton("랭킹", isSelected = selectedMenu == "랭킹", onMenuClick = onMenuClick)
    }
}
