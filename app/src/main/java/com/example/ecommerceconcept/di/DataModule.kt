package com.example.ecommerceconcept.di

import com.example.ecommerceconcept.data.retrofit.CartRequests
import com.example.ecommerceconcept.data.retrofit.DetailsRequests
import com.example.ecommerceconcept.data.retrofit.ExplorerRequests
import com.example.ecommerceconcept.domain.repository.CartRepository
import com.example.ecommerceconcept.domain.repository.DetailsRepository
import com.example.ecommerceconcept.domain.repository.ExplorerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideCategoryRequests() : ExplorerRepository{
        return ExplorerRequests()
    }

    @Provides
    fun provideDetailsRequests() : DetailsRepository{
        return DetailsRequests()
    }

    @Provides
    fun provideCartRequests() : CartRepository{
        return CartRequests()
    }
}