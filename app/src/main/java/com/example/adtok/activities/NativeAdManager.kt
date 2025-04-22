package com.example.adtok.activities

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.adtok.ui.theme.Modifiers
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.nativead.MediaView
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.nativead.NativeAdView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Arrays


/*class NativeAdManager(
    private val content: Int
) : Fragment() {
    // tokenTest = ca-app-pub-3940256099942544/1033173712

    var mInterstitialAd: InterstitialAd? = null
    val TAG = "MainActivity"
    var nativeAdView: MediaView? = null

    val adRequest = AdRequest.Builder().build()
    val textContent = "Hello from Fragment $content"
    lateinit var adView: NativeAdView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val textView = TextView(requireContext()).apply {
            text = textContent
            textSize = 24f
            gravity = Gravity.CENTER
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }


        this.adView = NativeAdView(requireContext())
        this.adView.apply {
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }

        return this.adView
    }


    override fun onStart() {
        super.onStart()

        this.loadAd(requireContext())
    }



    private fun loadAd(context: Context) {
        val testDeviceIds = listOf("1731DF315C19FE3286BF6D61D9129B8A")
        val configuration = RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build()
        MobileAds.setRequestConfiguration(configuration)


        // Test id : ca-app-pub-3940256099942544/1044960115
        val adLoader = AdLoader.Builder(context, "ca-app-pub-5707841394092803/8125887084")
            .withNativeAdOptions(
                NativeAdOptions.Builder().setAdChoicesPlacement(NativeAdOptions.ADCHOICES_TOP_LEFT).build()
            )
            .forNativeAd { nativeAd ->
                adView.setNativeAd(nativeAd)

                adView.headlineView = TextView(requireContext()).apply { text = nativeAd.headline }
            }
            .withAdListener(object : AdListener() {
                override fun onAdLoaded() {
                    Log.d("NATIVE AD", "AD LOADED")
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e("NATIVE AD", "ERROR WHILE LOADING THE AD $error")
                }
            })
            .build()

        adLoader.loadAd(AdRequest.Builder().build())
    }
}*/


class NativeAdManager(
    private val content: Int
) : Fragment() {
    private lateinit var adView: NativeAdView
    private var nativeAd: NativeAd? = null

    var headline: String? = null
    var body: String? = null





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val context = requireContext()


        // NativeAdView racine
        this.adView = NativeAdView(context).apply {
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }


        val padding = Modifiers.paddingLarge.value.toInt()
        // Layout programmatique de la pub
        val frameLayout = FrameLayout(context).apply {
            setPadding(padding, padding, padding, padding)
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

        // val body = TextView(context).apply {
        //     textSize = 16f
        //     setTextColor(Color.DKGRAY)
        // }

        val mediaView = MediaView(context).apply {
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }

        val verticalLayout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            addView(mediaView)
            addView(headline)
            // addView(body)
        }

        frameLayout.addView(verticalLayout)
        this.adView.addView(frameLayout)

        // Lier les vues à NativeAdView
        this.adView.mediaView = mediaView
        this.adView.headlineView = headline
        // this.adView.bodyView = body

        return this.adView
    }

    override fun onStart() {
        super.onStart()
        // this.loadAd(requireContext())
    }

    override fun onDestroyView() {
        nativeAd?.destroy()
        super.onDestroyView()
    }

    private fun loadAd(context: Context) {
        val adLoader = AdLoader.Builder(context, "ca-app-pub-5707841394092803/8125887084")
            .forNativeAd { ad ->
                nativeAd?.destroy()
                nativeAd = ad

                headline = ad.headline
                body = ad.body

                // Bind data to views
                (adView.headlineView as? TextView)?.text = headline
                (adView.bodyView as? TextView)?.text = body
                (adView.mediaView)?.mediaContent = ad.mediaContent

                adView.setNativeAd(ad)
            }
            .withNativeAdOptions(
                NativeAdOptions.Builder()
                    .setAdChoicesPlacement(NativeAdOptions.ADCHOICES_TOP_RIGHT)
                    .build()
            )
            .withAdListener(object : AdListener() {
                override fun onAdLoaded() {
                    Log.d("NATIVE_AD", "Ad loaded successfully.")
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e("NATIVE_AD", "Failed to load ad: $error")
                }
            })
            .build()

        adLoader.loadAd(AdRequest.Builder().build())
    }
}
