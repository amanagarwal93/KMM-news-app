package com.example.newsapp.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsapp.R
import com.example.newsapp.R.color
import com.example.newsapp.domain.model.Article
import com.example.newsapp.presentation.Dimens.articleCardSize
import com.example.newsapp.presentation.Dimens.extraSmallPadding
import com.example.newsapp.presentation.Dimens.extraSmallPadding2
import com.example.newsapp.presentation.Dimens.smallIconSize

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    Row(modifier = modifier.clickable { onClick() }) {
        AsyncImage(
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(articleCardSize)
                .clip(MaterialTheme.shapes.medium)
        )

        Column(
            verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .padding(horizontal = extraSmallPadding)
                .height(articleCardSize)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium.copy(),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = colorResource(id = color.text_title)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = color.body)
                )
                Spacer(modifier = Modifier.width(extraSmallPadding2))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(smallIconSize),
                    tint = colorResource(id = color.body)
                )
                Spacer(modifier = Modifier.width(extraSmallPadding))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }
}