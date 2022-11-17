package com.example.ecommerceconcept.data.retrofit

import com.example.ecommerceconcept.data.utills.getEmptyBasket
import com.example.ecommerceconcept.domain.models.BasketModel
import com.example.ecommerceconcept.domain.models.HotSalesModel
import com.example.ecommerceconcept.domain.repository.CartRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class CartRequests : CartRepository {

    private lateinit var mBasket : BasketModel

    override suspend fun getCart(): Flow<BasketModel> = callbackFlow {
        launch {
            mBasket = RetrofitInstance.apiService.getMyCart().body() ?: getEmptyBasket()
            send(mBasket)
        }
        awaitClose()
    }.distinctUntilChanged()
}