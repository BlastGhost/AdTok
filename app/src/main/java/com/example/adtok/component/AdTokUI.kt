package com.example.adtok.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.adtok.ui.theme.Modifiers

@Composable
fun AdTokUI(
    modifier: Modifier = Modifier,
    bottomInnerPadding: Dp = 0.dp,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(bottom = bottomInnerPadding),
        horizontalAlignment = Alignment.End,
    ) {
        Box(
            Modifier.padding(bottom = Modifiers.paddingMedium)
        ) {
            ActionsBar()
        }
        AdInfo(
            "Ad : II",
            "Brand Name "
        )
    }
}


@Preview
@Composable
private fun MainUIPreview() {
    AdTokUI()
}