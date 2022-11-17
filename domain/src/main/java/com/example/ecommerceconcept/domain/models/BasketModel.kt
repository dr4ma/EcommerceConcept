package com.example.ecommerceconcept.domain.models

data class BasketModel(
    val basket : MutableList<SingleElementCartModel>,
    val delivery : String,
    val id : Int,
    val total : Int
)
