package com.example.adtok.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

class Modifiers {
    companion object {
        val borderRadiusSmallDp = 6.dp
        val borderRadiusMediumDp = 10.dp
        val borderRadiusLargeDp = 12.dp
        val borderRadiusSmall = RoundedCornerShape(borderRadiusSmallDp)
        val borderRadiusMedium = RoundedCornerShape(borderRadiusMediumDp)
        val borderRadiusLarge = RoundedCornerShape(borderRadiusLargeDp)

        val paddingSmall = 6.dp
        val paddingMedium = 10.dp
        val paddingLarge = 20.dp

        val gapMedium = paddingMedium
        val gapLarge = paddingLarge


        val fontSizeSmall = TextUnit(14f, TextUnitType.Sp)
        val fontSizeMedium = TextUnit(18f, TextUnitType.Sp)
        val fontSizeLarge = TextUnit(24f, TextUnitType.Sp)

        val fontSizeBigTitle = TextUnit(56f, TextUnitType.Sp)


        val BOX = Modifier
            .fillMaxWidth()
            .clip(borderRadiusMedium)

        val INPUT_FIELD = BOX
            .background(Color.White)
            .border(2.dp, Color.Black, shape = borderRadiusMedium)
            .defaultMinSize(minHeight = 60.dp)
            // .height(40.dp)
            // .width(40.dp)

        val SEARCH_BAR = INPUT_FIELD

        val BUTTON = Modifier
            .height(52.dp)
            .width(52.dp)
            .clip(borderRadiusMedium)
            // .background(Color.DarkGray)
            // .border(2.dp, Color.White, shape = borderRadiusMedium)
    }
}