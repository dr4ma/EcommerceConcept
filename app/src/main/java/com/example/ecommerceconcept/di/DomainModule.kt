package com.example.ecommerceconcept.di

import com.example.ecommerceconcept.domain.repository.CartRepository
import com.example.ecommerceconcept.domain.repository.DetailsRepository
import com.example.ecommerceconcept.domain.repository.ExplorerRepository
import com.example.ecommerceconcept.domain.usecases.CartUseCase
import com.example.ecommerceconcept.domain.usecases.DetailsUseCase
import com.example.ecommerceconcept.domain.usecases.ExplorerUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideExplorerUseCase(repository: ExplorerRepository): ExplorerUseCase{
        return ExplorerUseCase(explorerRepository = repository)
    }

    @Provides
    fun provideDetailsUseCase(repository: DetailsRepository): DetailsUseCase{
        return DetailsUseCase(detailsRepository = repository)
    }

    @Provides
    fun provideCartUseCase(repository: CartRepository): CartUseCase{
        return CartUseCase(cartRepository = repository)
    }
}