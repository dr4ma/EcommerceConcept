package com.example.ecommerceconcept.domain.models

import com.example.ecommerceconcept.domain.markers.DisplayableItem

data class HotSalesModel(
    val id : Int,
    val is_new : Boolean,
    val title : String,
    val subtitle : String,
    val picture : String,
    val is_buy : Boolean
) : DisplayableItem
