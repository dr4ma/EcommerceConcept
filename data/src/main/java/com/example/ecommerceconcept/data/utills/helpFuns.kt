package com.example.ecommerceconcept.data.utills

import com.example.ecommerceconcept.domain.models.BasketModel
import com.example.ecommerceconcept.domain.models.DetailsModel

fun getEmptyDetails(): DetailsModel {
    return DetailsModel(
        CPU = "",
        camera = "",
        capacity = mutableListOf(),
        color = mutableListOf(),
        id = 0,
        images = mutableListOf(),
        isFavorites = false,
        price = 0,
        rating = 0.0,
        sd = "",
        ssd = "",
        title = ""
    )
}

fun getEmptyBasket(): BasketModel {
    return BasketModel(
        basket = mutableListOf(),
        delivery = "",
        id = 0,
        total = 0
    )
}
