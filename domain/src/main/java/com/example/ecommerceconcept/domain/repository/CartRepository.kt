package com.example.ecommerceconcept.domain.repository

import com.example.ecommerceconcept.domain.models.BasketModel
import com.example.ecommerceconcept.domain.models.DetailsModel
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun getCart() : Flow<BasketModel>
}