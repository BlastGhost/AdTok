package com.example.adtok.component

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.adtok.R


@Composable
fun <T> Swiper(
    contents: List<T>,
    modifier: Modifier = Modifier,
    padding: Dp = 0.dp,
    component: @Composable (content: T) -> Unit = { _: T -> },
) {
    val state = rememberLazyListState()

    val density = Resources.getSystem().displayMetrics.density
    val widthDp = Resources.getSystem().displayMetrics.widthPixels / density
    val heightDp = (Resources.getSystem().displayMetrics.heightPixels / density).dp - padding

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        state = state,
        flingBehavior = rememberSnapFlingBehavior(lazyListState = state)
    ) {
        items(contents.size) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .height(heightDp)
                    .background(colorResource(R.color.ad_tok_light_black))
                ,
                contentAlignment = Alignment.Center,
            ) {
                component(contents[it])
            }
        }
        /*items(10) { ii ->
                Text(
                    text = "$ii"
                )
        }*/
    }
}


@Preview(showBackground = true)
@Composable
fun SwipePreview() {
    val contents = IntRange(1, 10).toList()

    Swiper(contents) { content ->
        Text(
            text = "$content",
            color = Color.White
        )
    }
}