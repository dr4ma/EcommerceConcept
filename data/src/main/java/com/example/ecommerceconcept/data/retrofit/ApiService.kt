package com.example.ecommerceconcept.data.retrofit

import com.example.ecommerceconcept.data.utills.CART
import com.example.ecommerceconcept.data.utills.DETAILS
import com.example.ecommerceconcept.data.utills.HOT_SALES
import com.example.ecommerceconcept.domain.models.BasketModel
import com.example.ecommerceconcept.domain.models.BestSellerListModel
import com.example.ecommerceconcept.domain.models.DetailsModel
import com.example.ecommerceconcept.domain.models.HotSalesListModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(HOT_SALES)
    suspend fun getHotSales() : Response<HotSalesListModel>

    @GET(HOT_SALES)
    suspend fun getBestSeller() : Response<BestSellerListModel>

    @GET(CART)
    suspend fun getMyCart() : Response<BasketModel>

    @GET(DETAILS)
    suspend fun getDetails() : Response<DetailsModel>
}