package com.example.ecommerceconcept.domain.models

import com.example.ecommerceconcept.domain.markers.DisplayableItem

data class BestSellerModel(
    val id: Int,
    val is_favorites: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String
) : DisplayableItem