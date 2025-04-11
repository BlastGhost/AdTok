package com.example.adtok.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adtok.ui.theme.Modifiers

@Composable
fun Title(
    title: String,
    brand: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            title,
            fontSize = Modifiers.fontSizeLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            brand,
            fontSize = Modifiers.fontSizeSmall,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
    }
}








@Composable
@Preview
private fun PrePreview() {
    Title("Ad Name Title", "Brand Name")
}