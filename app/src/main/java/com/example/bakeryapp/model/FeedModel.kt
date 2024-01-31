package com.example.bakeryapp.model

import com.example.bakeryapp.dto.Product

data class FeedModel (
    val products: List<Product> = emptyList(),
    val loading: Boolean = false,
    val error: Boolean = false,
    val empty: Boolean = false,
    val refreshing: Boolean = false,
)