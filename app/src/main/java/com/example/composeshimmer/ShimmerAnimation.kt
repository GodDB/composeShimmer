package com.example.composeshimmer

import android.util.Log
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun ShimmerAnimation(
    maxWidth : Dp,
    content: @Composable (Brush) -> Unit
) {

    val width = with(LocalDensity.current) {
        maxWidth.toPx()
    }
    val infiniteTransition = rememberInfiniteTransition()
    val shimmerAnimator by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = width * 2,
        animationSpec = infiniteRepeatable(tween(1000))
    )

    val shimmerColorShades = listOf(
        Color.Gray.copy(0.9f),
        Color.Gray.copy(0.2f),
        Color.Gray.copy(0.9f)
    )
    val brush = Brush.linearGradient(
        colors = shimmerColorShades,
        start = Offset(0f, 0f),
        end = Offset(shimmerAnimator, shimmerAnimator)
    )

    content(brush)


}

