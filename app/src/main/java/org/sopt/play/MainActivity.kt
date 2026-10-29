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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
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
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier= Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.statusBarsPadding()) {
                MainTopBar()
                MainTabMenu()
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            HomeBanner()
            HomeCategory()
            HomeProductGrid()
        }
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
fun HomeProductGrid() {


    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item (span = { GridItemSpan(maxLineSpan)}) {
            HomeBanner()
        }

        item (span = { GridItemSpan(maxLineSpan)}) {
            HomeCategory()
        }

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
