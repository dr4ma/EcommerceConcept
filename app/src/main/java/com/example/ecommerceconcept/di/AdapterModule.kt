package com.example.ecommerceconcept.di

import com.example.ecommerceconcept.presentation.fragments.explorerFragment.CategoriesAdapter
import com.example.ecommerceconcept.presentation.fragments.explorerFragment.HotSalesAdapter
import com.example.ecommerceconcept.presentation.fragments.detailsFragment.ImagesDetailAdapter
import com.example.ecommerceconcept.presentation.fragments.adapterDelegates.MainListAdapter
import com.example.ecommerceconcept.presentation.fragments.adapterDelegates.delegates.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    @Singleton
    fun provideMainListAdapter(
        bestSellerAdapterDelegate: BestSellerAdapterDelegate,
        cartAdapterDelegate: CartAdapterDelegate
    ): MainListAdapter {
        return MainListAdapter(
            bestSellerAdapterDelegate = bestSellerAdapterDelegate,
            cartAdapterDelegate = cartAdapterDelegate
        )
    }

    @Provides
    @Singleton
    fun provideBestSellerDelegate(): BestSellerAdapterDelegate {
        return BestSellerAdapterDelegate()
    }

    @Provides
    @Singleton
    fun provideCartDelegate(): CartAdapterDelegate {
        return CartAdapterDelegate()
    }

    @Provides
    @Singleton
    fun provideCategoryAdapter(): CategoriesAdapter {
        return CategoriesAdapter()
    }

    @Provides
    @Singleton
    fun provideSalesAdapter(): HotSalesAdapter {
        return HotSalesAdapter()
    }

    @Provides
    @Singleton
    fun provideImagesAdapter(): ImagesDetailAdapter {
        return ImagesDetailAdapter()
    }
}