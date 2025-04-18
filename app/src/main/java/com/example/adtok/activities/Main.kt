package com.example.adtok.activities

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import com.example.adtok.component.ActionsBar
import com.example.adtok.component.AdInfo
import com.example.adtok.component.BottomNavBar
import com.example.adtok.component.Swiper
import com.example.adtok.ui.theme.AdTokTheme

@Composable
fun Main(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    val contents = IntRange(1, 10).toList()



    Swiper(
        contents,
        padding = innerPadding.calculateBottomPadding() + innerPadding.calculateTopPadding()
    ) { content ->
        Box(
            Modifier
                .fillMaxSize()
        ) {
            AdPlaceHolder(content)
        }

        Box(
            Modifier
                .fillMaxSize()
                // .align(Alignment.TopCenter)
            ,
            contentAlignment = Alignment.TopStart
        ) {
            AdInfo(
                "Ad : $content",
                "Brand Name "
            )
        }
    }
}


@Preview
@Composable
private fun MainPreview() {
    Main(PaddingValues(0.dp))
}