package com.example.adtok.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adtok.R
import com.example.adtok.ui.theme.Modifiers

@Composable
fun AdInfo(
    title: String,
    content: String,
    modifier: Modifier = Modifier,
) {
    var _title by remember { mutableStateOf(title) }
    var _content by remember { mutableStateOf(content) }



    Box(
        modifier
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
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                _title,
                fontSize = Modifiers.fontSizeLarge,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                _content,
                fontSize = Modifiers.fontSizeSmall,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        }
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