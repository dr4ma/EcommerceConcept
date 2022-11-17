package com.example.ecommerceconcept.presentation.activity.splashScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceconcept.domain.models.BestSellerModel
import com.example.ecommerceconcept.domain.models.HotSalesModel
import com.example.ecommerceconcept.domain.usecases.ExplorerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val explorerUseCase: ExplorerUseCase) : ViewModel() {

    val hotSales: MutableLiveData<MutableList<HotSalesModel>> = MutableLiveData()
    val bestSeller: MutableLiveData<MutableList<BestSellerModel>> = MutableLiveData()
    val countCart: MutableLiveData<Int> = MutableLiveData()

    fun getHotSales() {
        viewModelScope.launch {
            explorerUseCase.getHotSales().collect {
                hotSales.postValue(it)
            }
        }
    }

    fun getBestSeller() {
        viewModelScope.launch {
            explorerUseCase.getBestSeller().collect {
                bestSeller.postValue(it)
            }
        }
    }

    fun getCountCart() {
        viewModelScope.launch {
            explorerUseCase.getCountCart().collect {
                countCart.postValue(it.size)
            }
        }
    }
}