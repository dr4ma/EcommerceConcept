package com.example.ecommerceconcept.data.retrofit

import com.example.ecommerceconcept.domain.models.BestSellerModel
import com.example.ecommerceconcept.domain.models.HotSalesModel
import com.example.ecommerceconcept.domain.models.SingleElementCartModel
import com.example.ecommerceconcept.domain.repository.ExplorerRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class ExplorerRequests : ExplorerRepository {

    private var mHotSales = mutableListOf<HotSalesModel>()
    private var mBestSeller = mutableListOf<BestSellerModel>()
    private var mCart = mutableListOf<SingleElementCartModel>()

    override suspend fun getHotSales(): Flow<MutableList<HotSalesModel>> = callbackFlow {
        launch {
            mHotSales = RetrofitInstance.apiService.getHotSales().body()?.home_store ?: mutableListOf()
            send(mHotSales)
        }
        awaitClose()
    }.distinctUntilChanged()

    override suspend fun getBestSeller(): Flow<MutableList<BestSellerModel>> = callbackFlow {
        launch {
            mBestSeller =
                RetrofitInstance.apiService.getBestSeller().body()?.best_seller ?: mutableListOf()
            send(mBestSeller)
        }
        awaitClose()
    }.distinctUntilChanged()

    override suspend fun getCountCart(): Flow<MutableList<SingleElementCartModel>> = callbackFlow {
        launch {
            mCart = RetrofitInstance.apiService.getMyCart().body()?.basket ?: mutableListOf()
            send(mCart)
        }
        awaitClose()
    }.distinctUntilChanged()
}