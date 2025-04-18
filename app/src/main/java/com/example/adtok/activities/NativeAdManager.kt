package com.example.adtok.activities

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.nativead.MediaView
import com.google.android.gms.ads.nativead.NativeAdOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Arrays


class NativeAdManager(
    private val content: Int
) : Fragment() {
    // tokenTest = ca-app-pub-3940256099942544/1033173712

    var mInterstitialAd: InterstitialAd? = null
    val TAG = "MainActivity"
    var nativeAdView: MediaView? = null

    val adRequest = AdRequest.Builder().build()
    val textContent = "Hello from Fragment $content"


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

        return textView
    }


    override fun onStart() {
        super.onStart()

        val context = this.context
        val activity = this.activity

        // if (context != null && activity != null)
        //     this.loadAd(context, activity)
        // else
        //     Log.e(TAG, "ERROR WHILE LOADING THE ADD")
    }



    private fun loadAd(context: Context, activity: Activity) {
        val backgroundScope = CoroutineScope(Dispatchers.IO)
        backgroundScope.launch {
            // Initialize the Google Mobile Ads SDK on a background thread.
            MobileAds.initialize(context) {}
        }

        val testDeviceIds = listOf("1731DF315C19FE3286BF6D61D9129B8A")
        val configuration = RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build()
        MobileAds.setRequestConfiguration(configuration)


        val adLoader = AdLoader.Builder(context, "ca-app-pub-3940256099942544/1033173712")
            .withNativeAdOptions(
                NativeAdOptions.Builder().setAdChoicesPlacement(NativeAdOptions.ADCHOICES_TOP_LEFT).build()
            )
            .forNativeAd { nativeAd ->

            }
            .build()

        adLoader.loadAd(AdRequest.Builder().build())
    }
}