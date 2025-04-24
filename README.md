This project was carried out as part of a course at the University of Le Mans on programming
on embedded interface programming on android.

the project has not been completed. So not all interfaces are implemented, and some implementation methods are too barbaric. 
This is due to our lack of competence and knowledge in the field of android.

# What is AdTok ?
AdTok is the TikTok of ads. Anyone can watch, like, share and comment on ads. 
By watching ads, you earn points that you can use to buy packs with exclusive ads and even rare ads to collect.


# API
In this project, we use the [Google AdMob API](https://developers.google.com/admob).

This is one of most popular API providing ads to mobile application and Unity game. When using it, please make sure to use the right ID for test. [See more here](https://developers.google.com/admob/android/test-ads)

## Native Ad
In our project, we need to use Native Ad as we can place them where we need them and we can also define their dimensions.

Here is the test ID to use when using native ad in your application `ca-app-pub-3940256099942544/2247696110`.

### Display Native Ad

The following code shows how to request a Native Ad 
```kotlin
 val adLoader = AdLoader.Builder(context, "ca-app-pub-...")
    .forNativeAd { nativeAd ->
        // You can access the ad data here
    }
    .withNativeAdOptions(
        NativeAdOptions.Builder()
            .setAdChoicesPlacement(NativeAdOptions.ADCHOICES_TOP_RIGHT)
            .build()
    )
    .withAdListener(object : AdListener() {
        // You can also handle when the ad is loaded by using onAdLoaded
        // But you don't have access to the ad data
        
        // Handle Error
        // Don't request a new ad in this handler
        override fun onAdFailedToLoad(error: LoadAdError) {
            Log.e("NATIVE_AD", "Failed to load ad: $error")
        }
    })
    .build()

adLoader.loadAd(AdRequest.Builder().build())
```

You can show the Native Ad using Views
```kotlin
var mNativeAd: NativeAd? = null
lateinit var adView: NativeAdView // We assume you create the NativeAdView correctly

AdLoader.Builder(context, "ca-app-pub-...")
    .forNativeAd { nativeAd ->
        mNativeAd?.destroy()
        mNativeAd = nativeAd

        // Bind data to views
        (adView.headlineView as? TextView)?.text = nativeAd.headline
        (adView.bodyView as? TextView)?.text = nativeAd.body
        (adView.mediaView)?.mediaContent = nativeAd.mediaContent

        adView.setNativeAd(ad)
    }
```

Or you can show the Native Ad using Compose

```kotlin
var mNativeAd by remember { mutableStateOf<NativeAd?>(null) }

DisposableEffect(Unit) {
    val adLoader = AdLoader.Builder(context, "ca-app-pub-...")
        .forNativeAd { nativeAd ->
            mNativeAd = nativeAd
        }.withNativeAdOptions(
            NativeAdOptions.Builder()
                .setAdChoicesPlacement(NativeAdOptions.ADCHOICES_TOP_RIGHT)
                .build()
        )
        .withAdListener(object : AdListener() {
            override fun onAdFailedToLoad(error: LoadAdError) {
                Log.e("NATIVE_AD", "$error")
            }
        })
        .build()

    adLoader.loadAd(AdRequest.Builder().build())

    onDispose {
        mNativeAd?.destroy()
    }
}

if (mNativeAd != null)
    MyAdComponent(mNativeAd)
else
    LoadingAd()
```