package com.technonext.feed_presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.technonext.designsystem.r
import com.technonext.designsystem.theme.bodyBoldTextStyle
import com.technonext.designsystem.theme.bodyRegularTextStyle
import com.technonext.designsystem.utils.DrawableCircleImageUrl
import com.technonext.designsystem.utils.ErrorRow
import com.technonext.designsystem.utils.LoadingRow
import com.technonext.designsystem.utils.OnBottomReached
import com.technonext.feed_domain.model.ProductModel

@Composable
fun FeedScreen(viewModel: FeedViewModel = hiltViewModel()) {
    val listState = rememberLazyListState()

    // fire when near bottom
    listState.OnBottomReached(buffer = 3) {
        viewModel.loadNextPage()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(state = listState, verticalArrangement = Arrangement.spacedBy(10.r())) {
            itemsIndexed(viewModel.state.productsList) { _, item ->
                ProductRow(item)
            }

            item {
                when {
                    viewModel.state.isLoading -> LoadingRow("Loading…")
                    else -> ErrorRow(viewModel.state.error) { viewModel.loadNextPage() }
                }
            }
        }
    }
}


@Composable
fun ProductRow(item: ProductModel) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.r())
            ) {
                Text(text = item.title, style = bodyBoldTextStyle.copy(textAlign = TextAlign.Start))

                Spacer(modifier = Modifier.height(10.r()))

                Text(
                    text = item.description,
                    style = bodyRegularTextStyle.copy(textAlign = TextAlign.Start)
                )
            }

            if (item.images.isNotEmpty()) {
                Spacer(modifier = Modifier.height(10.r()))
                DrawableCircleImageUrl(
                    imageUrl = item.images[0],
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.r())
                )
            }
        }
    }
}


@Composable
@Preview
fun PreviewFeedScreen() {
    FeedScreen()
}