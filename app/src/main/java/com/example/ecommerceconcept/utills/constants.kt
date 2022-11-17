package com.example.ecommerceconcept.utills

import com.example.ecommerceconcept.domain.markers.DisplayableItem
import com.example.ecommerceconcept.domain.models.HotSalesModel
import com.example.ecommerceconcept.presentation.activity.MainActivity

lateinit var APP_ACTIVITY_MAIN : MainActivity

var HOT_SALES = mutableListOf<HotSalesModel>()
var COUNT_CART = 0
var BEST_SELLER = mutableListOf<DisplayableItem>()