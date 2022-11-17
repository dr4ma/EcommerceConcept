package com.example.ecommerceconcept.domain.usecases

import com.example.ecommerceconcept.domain.models.BestSellerModel
import com.example.ecommerceconcept.domain.models.HotSalesModel
import com.example.ecommerceconcept.domain.models.SingleElementCartModel
import com.example.ecommerceconcept.domain.repository.ExplorerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class ExplorerUseCase @Inject constructor(private val explorerRepository: ExplorerRepository) {

    suspend fun getHotSales(): Flow<MutableList<HotSalesModel>> = flow {
        explorerRepository.getHotSales().collect {
            emit(it)
        }
    }.flowOn(Dispatchers.IO).distinctUntilChanged()

    suspend fun getBestSeller(): Flow<MutableList<BestSellerModel>> = flow {
        explorerRepository.getBestSeller().collect {
            emit(it)
        }
    }.flowOn(Dispatchers.IO).distinctUntilChanged()

    suspend fun getCountCart(): Flow<MutableList<SingleElementCartModel>> = flow {
        explorerRepository.getCountCart().collect {
            emit(it)
        }
    }.flowOn(Dispatchers.IO).distinctUntilChanged()
}