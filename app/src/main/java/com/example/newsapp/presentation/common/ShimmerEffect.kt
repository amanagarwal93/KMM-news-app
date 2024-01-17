package com.example.newsapp.presentation.common

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsapp.R
import com.example.newsapp.presentation.Dimens
import com.example.newsapp.presentation.Dimens.mediumPadding1

fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition()
    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        )
    ).value
    background(color = colorResource(id = R.color.shimmer).copy(alpha = alpha))
}

@Composable
fun ArticleShimmerEffect(modifier: Modifier = Modifier) {

    Row(modifier = modifier) {
        Box(
            modifier = Modifier
                .size(Dimens.articleCardSize)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
        )

        Column(
            verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .padding(horizontal = Dimens.extraSmallPadding)
                .height(Dimens.articleCardSize)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(horizontal = mediumPadding1)
                    .shimmerEffect()
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(15.dp)
                        .padding(horizontal = mediumPadding1)
                        .shimmerEffect()
                )
            }
        }
    }

}

