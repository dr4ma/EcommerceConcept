package com.example.ecommerceconcept.presentation.fragments.cartFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceconcept.domain.models.BasketModel
import com.example.ecommerceconcept.domain.models.DetailsModel
import com.example.ecommerceconcept.domain.usecases.CartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val cartUseCase: CartUseCase) : ViewModel() {

    val basket: MutableLiveData<BasketModel> = MutableLiveData()

    fun getCart() {
        viewModelScope.launch {
            cartUseCase.getCart().collect {
                basket.postValue(it)
            }
        }
    }
}