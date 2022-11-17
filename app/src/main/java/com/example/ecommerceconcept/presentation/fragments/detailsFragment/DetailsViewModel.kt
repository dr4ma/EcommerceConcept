package com.example.ecommerceconcept.presentation.fragments.detailsFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceconcept.domain.models.BestSellerModel
import com.example.ecommerceconcept.domain.models.DetailsModel
import com.example.ecommerceconcept.domain.usecases.DetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val detailsUseCase: DetailsUseCase) : ViewModel() {

    val details: MutableLiveData<DetailsModel> = MutableLiveData()

    fun getDetails() {
        viewModelScope.launch {
            detailsUseCase.getDetails().collect {
                details.postValue(it)
            }
        }
    }
}