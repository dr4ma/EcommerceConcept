package com.example.ecommerceconcept.domain.models

import com.example.ecommerceconcept.domain.markers.DisplayableItem

data class DetailsModel(
    val CPU : String,
    val camera : String,
    val capacity : MutableList<String>,
    val color : MutableList<String>,
    val id : Int,
    val images : MutableList<String>,
    val isFavorites : Boolean,
    val price : Int,
    val rating : Double,
    val sd : String,
    val ssd : String,
    val title : String
) : DisplayableItem
