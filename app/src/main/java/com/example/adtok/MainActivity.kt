package com.example.adtok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.adtok.component.ActionsBar
import com.example.adtok.component.AdInfo
import com.example.adtok.component.AdTokUI
import com.example.adtok.component.BottomNavBar
import com.example.adtok.component.Swiper
import com.example.adtok.ui.theme.AdTokTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
        }
    }
}


@Composable
private fun Main(modifier: Modifier = Modifier) {
    val contents = IntRange(1, 10).toList()

    AdTokTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {  },
            bottomBar = { BottomNavBar() },
            floatingActionButton = { ActionsBar() },
        ) { innerPadding ->
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Swiper(
                    contents,
                    padding = innerPadding.calculateBottomPadding() + innerPadding.calculateTopPadding()
                ) { content ->
                    Text(
                        text = "$content",
                        color = Color.White
                    )
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter)
                    ) {
                        AdInfo(
                            "Ad : $content",
                            "Brand Name "
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    Main()
}