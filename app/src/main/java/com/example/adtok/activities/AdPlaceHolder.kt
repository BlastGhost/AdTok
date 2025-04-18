package com.example.adtok.activities

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun AdPlaceHolder(
    content: Int,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val fragmentManager = (context as AppCompatActivity).supportFragmentManager
    val fragmentContainerId = remember { View.generateViewId() }


    AndroidView(
        factory = { ctx ->
            FrameLayout(ctx).apply {
                id = fragmentContainerId
                fragmentManager.beginTransaction()
                    .replace(id, NativeAdManager(content)) // Ton fragment personnalisé
                    .commit()
            }
        },
        modifier = Modifier.fillMaxSize()
    )

    /*
    val fragmentContainer = FrameLayout(context).apply {
        id = fragmentContainerId
        parent
        layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
    }

    context.addContentView(fragmentContainer, ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT,
    ))

    fragmentManager.beginTransaction()
        .replace(fragmentContainer.id, NativeAdManager())
        .commit()

     */
}