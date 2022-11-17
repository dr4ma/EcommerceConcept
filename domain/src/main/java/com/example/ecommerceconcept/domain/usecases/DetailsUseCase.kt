package com.example.ecommerceconcept.domain.usecases

import com.example.ecommerceconcept.domain.models.DetailsModel
import com.example.ecommerceconcept.domain.models.HotSalesModel
import com.example.ecommerceconcept.domain.repository.DetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DetailsUseCase @Inject constructor(private val detailsRepository: DetailsRepository) {

    suspend fun getDetails() : Flow<DetailsModel> = flow {
        detailsRepository.getDetails().collect {
            emit(it)
        }
    }.flowOn(Dispatchers.IO).distinctUntilChanged()
}