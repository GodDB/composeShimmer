package com.example.composeshimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

@Composable
fun ShimmerView(modifier: Modifier, shape: Shape = RectangleShape) {
    BoxWithConstraints {
        ShimmerAnimation(maxWidth) { brush ->
            Spacer(
                modifier = modifier
                    .background(brush, shape)
            )
        }
    }
}
