package com.example.adtok.component

import android.content.res.Resources
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun SwipePreview() {
    val state = rememberLazyListState()

    val density = Resources.getSystem().displayMetrics.density
    val widthDp = Resources.getSystem().displayMetrics.widthPixels / density
    val heightDp = (Resources.getSystem().displayMetrics.heightPixels / density).dp
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        state = state,
        flingBehavior = rememberSnapFlingBehavior(lazyListState = state)
    ) {
        items(10) { ii ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(heightDp)
            ) {
                Text(
                    text = "$ii"
                )
            }
        }
    }
}