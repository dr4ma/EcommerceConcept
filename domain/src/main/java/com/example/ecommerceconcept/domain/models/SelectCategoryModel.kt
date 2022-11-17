package com.example.ecommerceconcept.domain.models

import com.example.ecommerceconcept.domain.markers.DisplayableItem

data class SelectCategoryModel(
    val icon: Int,
    val label: String
) : DisplayableItem
