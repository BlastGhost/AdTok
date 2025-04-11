package com.example.adtok.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.adtok.ui.theme.Modifiers

@Composable
fun ActionsBar(modifier: Modifier = Modifier) {
    Column(
        Modifier,
        verticalArrangement = Arrangement.spacedBy(Modifiers.paddingLarge),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AtButton(
            "Like",
            sub = "0000",
            icon = Icons.Rounded.FavoriteBorder,
            onClick = {},
        )
        AtButton(
            "Comment",
            sub = "000",
            icon = Icons.Rounded.Edit,
            onClick = {},
        )
        AtButton(
            "Share",
            sub = "000",
            icon = Icons.Rounded.Share,
            onClick = {},
        )
    }
}



@Composable
@Preview
private fun BarPreview() {
    ActionsBar()
}