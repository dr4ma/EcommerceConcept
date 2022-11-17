package com.example.ecommerceconcept.domain.models

import com.example.ecommerceconcept.domain.markers.DisplayableItem

data class SingleElementCartModel(
    val id : Int,
    val images : String,
    val price : Int,
    val title : String
) : DisplayableItem
