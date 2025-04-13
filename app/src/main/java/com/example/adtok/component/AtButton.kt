package com.example.adtok.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adtok.ui.theme.Modifiers

@Composable
fun AtButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    sub: String? = null,
) {
    Box(
        Modifiers
            .BUTTON
            .padding(Modifiers.paddingSmall)
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        Column(
            Modifier
                .matchParentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (icon != null)
                Icon(
                    icon,
                    label,
                    tint = Color.White,
                )
            else
                Text(
                    label,
                    color = Color.White,
                    fontSize = Modifiers.fontSizeSmall,
                )

            if (sub != null)
                Text(
                    sub,
                    color = Color.White,
                    fontSize = Modifiers.fontSizeExtraSmall,
                    fontWeight = FontWeight.Light
                )
        }
    }
}



@Composable
@Preview
private fun ButtonPreview() {
    Column {
        AtButton(
            label = "Test",
            icon = Icons.Rounded.Share,
            onClick = {},
        )

        AtButton(
            label = "Test",
            onClick = {},
        )

        AtButton(
            label = "Test",
            sub = "000",
            icon = Icons.Rounded.Person,
            onClick = {},
        )

        IconButton(
            {}
        ) {
            Column {
                Icon(Icons.Rounded.Edit, contentDescription = "Test", tint = Color.White)
                Text("Test")
            }
        }
    }
}