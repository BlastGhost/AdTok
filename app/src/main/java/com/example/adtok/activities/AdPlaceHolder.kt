package com.example.adtok.activities

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import coil3.compose.AsyncImage
import com.example.adtok.R
import com.example.adtok.component.AdCard
import com.example.adtok.component.AdInfo
import com.example.adtok.ui.theme.Modifiers
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions

@Composable
fun AdPlaceHolder(
    ad: NativeAdManager,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val fragmentManager = (context as AppCompatActivity).supportFragmentManager
    val fragmentContainerId = remember { View.generateViewId() }


    /*AndroidView(
        factory = { ctx ->
            FrameLayout(ctx).apply {
                id = fragmentContainerId
                fragmentManager.beginTransaction()
                    .replace(id, ad) // Ton fragment personnalisé
                    .commit()
            }
        },
        modifier = Modifier.fillMaxSize()
    )
     */



    var nativeAd by remember { mutableStateOf<NativeAd?>(null) }

    DisposableEffect(Unit) {
        val adLoader = AdLoader.Builder(context, "ca-app-pub-5707841394092803/8125887084")
            .forNativeAd { ad ->
                nativeAd = ad
            }.withNativeAdOptions(
                NativeAdOptions.Builder()
                    .setAdChoicesPlacement(NativeAdOptions.ADCHOICES_BOTTOM_LEFT)
                    .build()
            )
            .withAdListener(object : AdListener() {
                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e("NATIVE_AD", "Failed to load ad: $error")
                }
            })
            .build()

        adLoader.loadAd(AdRequest.Builder().build())

        onDispose {
            nativeAd?.destroy()
        }
    }

    if (nativeAd != null)
        Ad(nativeAd)
    else
        LoadingAd()
}


@Composable
fun Ad(
    ad: NativeAd?,
    modifier: Modifier = Modifier
) {
    Box(
        Modifier.fillMaxSize()
    ) {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            AdCard(ad)
        }
        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
            // .align(Alignment.TopCenter)
            ,
            contentAlignment = Alignment.TopStart
        ) {
            AdInfo(
                ad?.headline ?: "",
                ad?.body ?: "",
                modifier = Modifier.matchParentSize()
            )
        }
    }
}


@Composable
fun LoadingAd(
    modifier: Modifier = Modifier
) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            stringResource(R.string.ad_loading),
            color = Color.White,
            fontSize = Modifiers.fontSizeLarge,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview
@Composable
private fun PlaceHolderPreview() {
    LoadingAd()
}