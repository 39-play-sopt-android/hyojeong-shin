package org.sopt.play

import android.R.attr.right
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.H
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import org.sopt.play.ui.theme.PlaySoptTheme
import org.sopt.play.ui.theme.SoptColor
import org.sopt.play.ui.theme.SoptTypography
import kotlin.getValue


class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaySoptTheme() {
                MainScreen(viewModel=mainViewModel)
            }
        }
    }
}

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    modifier: Modifier= Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.statusBarsPadding()) {
                MainTopBar()
                MainTabMenu(
                    selectedMenu = viewModel.selectedMenu,
                    onMenuClick = { menu -> viewModel.onMenuClick(menu) }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            HomeProductGrid(
                selectedChip = viewModel.selectedChip,
                onChipClick = { chip -> viewModel.onChipClick(chip) },
                likedProducts = viewModel.likedProducts,
                onLikeClick = { index -> viewModel.onLikeClick(index) }
            )
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
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        val bannerWidth = maxWidth

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf(
                R.drawable.banner1,
                R.drawable.banner2,
                R.drawable.banner3
            ).forEach { image ->
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier
                        .width(bannerWidth)
                        .aspectRatio(328f / 195f),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}



@Composable
fun HomeProductGrid(
    selectedChip: String,
    onChipClick: (String) -> Unit,
    likedProducts: Set<Int>,
    onLikeClick: (Int) -> Unit
) {


    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item (span = { GridItemSpan(maxLineSpan)}) {
            HomeBanner()
        }

        item (span = { GridItemSpan(maxLineSpan)}) {
            HomeCategory(
                selectedChip = selectedChip,
                onChipClick = onChipClick
            )
        }

        items(products.size) { index ->
            val isLiked = index in likedProducts

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(176f / 315f)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(products[index].image),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(176f / 220f),
                        contentScale = ContentScale.FillBounds
                    )
                    IconButton(
                        onClick = { onLikeClick(index) },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(8.dp)
                    ) {
                        Icon(
                            painter = painterResource(
                                if (isLiked) R.drawable.ic_favorite_fill
                                else R.drawable.ic_favorite
                            ),
                            contentDescription = if (isLiked) "좋아요 취소" else "좋아요",
                            tint = Color.Unspecified
                        )
                    }
                }
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
                        style = SoptTypography.r14,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis)
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlaySoptTheme() {
        MainScreen(MainViewModel())
    }
}
