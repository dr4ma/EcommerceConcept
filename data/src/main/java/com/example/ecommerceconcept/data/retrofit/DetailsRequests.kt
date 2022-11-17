package com.example.ecommerceconcept.data.retrofit

import com.example.ecommerceconcept.data.utills.getEmptyDetails
import com.example.ecommerceconcept.domain.models.DetailsModel
import com.example.ecommerceconcept.domain.models.SingleElementCartModel
import com.example.ecommerceconcept.domain.repository.DetailsRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class DetailsRequests : DetailsRepository {

    private lateinit var mDetails : DetailsModel

    override suspend fun getDetails(): Flow<DetailsModel> = callbackFlow {
        launch {
            mDetails = RetrofitInstance.apiService.getDetails().body() ?: getEmptyDetails()
            send(mDetails)
        }
        awaitClose()
    }.distinctUntilChanged()
}