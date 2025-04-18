package com.example.adtok

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.adtok.activities.AdManager
import com.example.adtok.activities.Main
import com.example.adtok.activities.NativeAdManager
import com.example.adtok.component.ActionsBar
import com.example.adtok.component.AdInfo
import com.example.adtok.component.AdTokUI
import com.example.adtok.component.BottomNavBar
import com.example.adtok.component.Swiper
import com.example.adtok.ui.theme.AdTokTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdTokTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { },
                    bottomBar = { BottomNavBar() },
                    floatingActionButton = { ActionsBar() },
                ) { innerPadding ->
                    Box(
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Main(innerPadding)
                    }
                }
            }
        }


    }
}



@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    // Main()
}