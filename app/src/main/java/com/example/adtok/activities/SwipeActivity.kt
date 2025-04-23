package com.example.adtok.activities

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adtok.MainActivity
import com.example.adtok.component.ActionsBar
import com.example.adtok.component.BottomNavBar
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.nativead.NativeAd
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SwipeActivity : AppCompatActivity() {

    private var nativeAd: NativeAd? = null

    internal var x1: Float = 0.toFloat()
    internal var x2: Float = 0.toFloat()
    internal var y1: Float = 0.toFloat()
    internal var y2: Float = 0.toFloat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val density = Resources.getSystem().displayMetrics.density
        val widthDp = Resources.getSystem().displayMetrics.widthPixels / density
        val heightDp = ((Resources.getSystem().displayMetrics.heightPixels.dp) / density)

        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())

        this.initAdMob()

        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { },
                bottomBar = { BottomNavBar() },
                floatingActionButton = { ActionsBar() },
            ) { innerPadding ->
                var offset by remember { mutableStateOf(0f) }
                Box(
                    Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .scrollable(
                            orientation = Orientation.Horizontal,
                            // Scrollable state: describes how to consume
                            // scrolling delta and update offset
                            state = rememberScrollableState { delta ->
                                offset += delta
                                if (offset.dp < widthDp.dp*-1) {
                                    val intent = Intent(this@SwipeActivity, SwipeActivity::class.java)
                                    Log.d("activity", "Start new activity")
                                    startActivity(intent)
                                }
                                delta
                            },
                        )
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Main(innerPadding)
                }
            }

        }
    }

    private fun initAdMob() {
        val backgroundScope = CoroutineScope(Dispatchers.IO)
        backgroundScope.launch {
            // Initialize the Google Mobile Ads SDK on a background thread.
            MobileAds.initialize(this@SwipeActivity) {}
        }

        val testDeviceIds = listOf("1731DF315C19FE3286BF6D61D9129B8A")
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(testDeviceIds)
                .build()
        )
    }
}