package org.sopt.play

import android.R.attr.right
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.H
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.ui.theme.PlaySoptTheme
import org.sopt.play.ui.theme.SoptColor
import org.sopt.play.ui.theme.SoptTypography


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaySoptTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerpading ->
                    MainScreen(modifier = Modifier.padding(innerpading)
                    )}

            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier= Modifier
) {
    Column(
        modifier= Modifier
            .fillMaxWidth()

    ) {
        MainTopBar()
        HomeBanner()
        MainTabMenu()
        HomeCategory()
        HomeProductGrid()
    }

}

@Composable
fun MainTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(start = 16.dp, end = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "PLAY SOPT",
            color = SoptColor.Black,
            style = SoptTypography.b28
        )
        Image(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )

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


@Composable
fun HomeBanner() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.banner1),
            contentDescription = null,
            modifier = Modifier.size(
                width = 328.dp,
                height = 195.dp
            ),
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(R.drawable.banner2),
            contentDescription = null,
            modifier = Modifier.size(
                width = 328.dp,
                height = 195.dp),
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(R.drawable.banner3),
            contentDescription = null,
            modifier = Modifier.size(
                width = 328.dp,
                height = 195.dp
                ),
            contentScale = ContentScale.FillBounds
        )

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
            )
    ) {
        Text("신효정님을 위한 추천 아이템")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
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


@Composable
fun HomeProductGrid() {


    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(products.size) { index ->
            Column(
                modifier = Modifier
                    .width(176.dp)
                    .height(315.dp)
            ) {
                Image(
                    painter = painterResource(products[index].image),
                    contentDescription = null,
                    modifier = Modifier
                        .width(176.dp)
                        .height(220.dp),
                    contentScale = ContentScale.FillBounds
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .padding(top=12.dp, bottom=20.dp)
                ) {
                    Text(products[index].shop,
                        color = SoptColor.Black,
                        style = SoptTypography.m14)
                    Text(products[index].name,
                        color = SoptColor.Black,
                        style = SoptTypography.r14)
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlaySoptTheme() {
        MainScreen()
    }
}