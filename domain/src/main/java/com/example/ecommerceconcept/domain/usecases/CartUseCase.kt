package com.example.ecommerceconcept.domain.usecases

import com.example.ecommerceconcept.domain.models.BasketModel
import com.example.ecommerceconcept.domain.models.DetailsModel
import com.example.ecommerceconcept.domain.repository.CartRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CartUseCase @Inject constructor(private val cartRepository: CartRepository) {

    suspend fun getCart() : Flow<BasketModel> = flow {
        cartRepository.getCart().collect {
            emit(it)
        }
    }.flowOn(Dispatchers.IO).distinctUntilChanged()
}