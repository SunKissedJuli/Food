package com.example.food.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.food.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageViewer() {
    val images = listOf(
        painterResource(R.drawable.icon_restoran_image),
        painterResource(R.drawable.icon_restoran_image),
        painterResource(R.drawable.icon_restoran_image),
        painterResource(R.drawable.icon_restoran_image),
        painterResource(R.drawable.icon_restoran_image),
    )
    val pagerState = rememberPagerState()

    Box(modifier = Modifier.fillMaxWidth()){
        Column(modifier = Modifier.fillMaxWidth()) {
            HorizontalPager(
                count = images.size,
                state = pagerState,
                modifier = Modifier.fillMaxWidth().height(300.dp)) { page ->

                Image(painter = images[page],
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                        .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)),
                    contentScale = ContentScale.Crop)
            }
        }

        Box(Modifier.align(Alignment.BottomCenter)){
            IndicatorDots(pagerState = pagerState, imageCount = images.size)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun IndicatorDots(pagerState: PagerState, imageCount: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(imageCount) { index ->

            if(index==pagerState.currentPage){
                Box(modifier = Modifier
                    .size(19.dp)
                    .clip(CircleShape)
                    .background(Color.Transparent)
                    .border(width = 1.29.dp, shape = CircleShape, color = MaterialTheme.colorScheme.background)){
                    Box(modifier = Modifier
                        .size(8.dp)
                        .align(Alignment.Center)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.background)
                    )
                }

            }else{
                Box(modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .alpha(0.4f)
                    .background(MaterialTheme.colorScheme.background)
                )
            }


            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}