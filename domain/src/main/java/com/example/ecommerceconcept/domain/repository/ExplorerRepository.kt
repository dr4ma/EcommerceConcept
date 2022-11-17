package com.example.ecommerceconcept.domain.repository

import com.example.ecommerceconcept.domain.models.BestSellerModel
import com.example.ecommerceconcept.domain.models.HotSalesModel
import com.example.ecommerceconcept.domain.models.SingleElementCartModel
import kotlinx.coroutines.flow.Flow

interface ExplorerRepository {

    suspend fun getHotSales() : Flow<MutableList<HotSalesModel>>
    suspend fun getBestSeller() : Flow<MutableList<BestSellerModel>>
    suspend fun getCountCart() : Flow<MutableList<SingleElementCartModel>>
}