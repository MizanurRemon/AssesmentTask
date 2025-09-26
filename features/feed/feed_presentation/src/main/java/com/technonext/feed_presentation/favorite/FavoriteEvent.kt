package com.technonext.feed_presentation.favorite

sealed class FavoriteEvent {
    data class OnFavoriteClickEvent(val productId: Int, val isFavorite: Boolean): FavoriteEvent()
}