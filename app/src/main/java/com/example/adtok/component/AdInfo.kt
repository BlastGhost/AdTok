package com.example.adtok.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adtok.R
import com.example.adtok.ui.theme.Modifiers

@Composable
fun AdInfo(
    title: String,
    brandName: String,
    modifier: Modifier = Modifier,
) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(R.color.ad_tok_black),
                        Color.Transparent,
                    ),
                    startY = 50f,
                ),
            )
            .padding(horizontal = Modifiers.paddingMedium, vertical = Modifiers.paddingMedium),
        contentAlignment = Alignment.CenterStart,
    ) {
        Title(
            title,
            brandName
        )
    }
}




@Preview
@Composable
private fun HeaderPreview() {
    AdInfo(
        "Ad Name Title",
        "Brand Name "
    )
}