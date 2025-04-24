package com.example.adtok.component

import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.widget.FrameLayout
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.nativead.MediaView
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView

@Composable
fun AdCard(
    ad: NativeAd?,
    modifier: Modifier = Modifier
) {
    /*
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        AsyncImage(
            model = ad?.icon?.uri,
            contentDescription = "Ad Icon",
            modifier = Modifier
                .size(50.dp)
                .padding(end = 16.dp),
            contentScale = ContentScale.Fit
        )
    }
     */


    AndroidView(
        factory = { context ->
            // NativeAdView racine
            val adView = NativeAdView(context).apply {
                layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
            }

            val headline = TextView(context).apply {
                textSize = 0f
                setTextColor(Color.TRANSPARENT)
                setTypeface(null, Typeface.BOLD)
            }

            val mediaView = MediaView(context).apply {
                layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
            }


            // Lier les vues a NativeAdView
            adView.headlineView = headline
            adView.mediaView = mediaView

            (adView.headlineView as? TextView)?.text = ad?.headline
            (adView.mediaView)?.mediaContent = ad?.mediaContent

            if (ad != null)
                adView.setNativeAd(ad)
            else
                Log.e("AdCard", "Error while loading the Ad in card : ad null")

            adView.addView(mediaView)


            return@AndroidView adView
        },
        modifier = Modifier
            .fillMaxSize()
    )
}