package com.technonext.feed_presentation.feed

sealed class FeedEvent {
    data class OnFavoriteClickEvent(val productId: Int, val isFavorite: Boolean): FeedEvent()
}