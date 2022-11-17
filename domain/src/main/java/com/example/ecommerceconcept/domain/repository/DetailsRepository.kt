package com.example.ecommerceconcept.domain.repository

import com.example.ecommerceconcept.domain.models.DetailsModel
import kotlinx.coroutines.flow.Flow

interface DetailsRepository {
    suspend fun getDetails() : Flow<DetailsModel>
}