package com.example.adtok.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adtok.ui.theme.AdTokTheme
import com.example.adtok.ui.theme.Modifiers

@Composable
fun UI(modifier: Modifier = Modifier) {
    AdTokTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Box(
                Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black,
                                    Color.Transparent,
                                ),
                                startY = 50f,
                            ),
                        )
                        .padding(Modifiers.paddingLarge)
                        .align(Alignment.TopStart)
                ) {
                    Title(
                        "Ad Name Title",
                        "Brand Name "
                    )
                }

                Column(
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    horizontalAlignment = Alignment.End
                ) {
                    Box(
                        Modifier.padding(bottom = Modifiers.paddingLarge, end = Modifiers.paddingLarge)
                    ) {
                        ActionsBar()
                    }
                    BottomNavBar()
                }
            }
        }
    }
}


@Composable
@Preview
private fun UiPreview() {
    UI()
}