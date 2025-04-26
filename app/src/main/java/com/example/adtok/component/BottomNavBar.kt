package com.example.adtok.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.adtok.R
import com.example.adtok.ui.theme.Modifiers

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    padding: Dp = 0.dp,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.ad_tok_black))
            .defaultMinSize(minHeight = 60.dp)
            .padding(horizontal = 80.dp, vertical = Modifiers.paddingMedium)
            .padding(bottom = padding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AtButton(
            stringResource(R.string.bottom_nav_bar_home),
            sub = stringResource(R.string.bottom_nav_bar_home),
            icon = Icons.Rounded.Home,
            onClick = {}
        )

        AtButton(
            stringResource(R.string.bottom_nav_bar_profile),
            sub = stringResource(R.string.bottom_nav_bar_profile),
            icon = Icons.Rounded.Person,
            onClick = {}
        )
    }
}


@Composable
@Preview
private fun BottomNavBarPreview() {
    BottomNavBar()
}