package com.example.ecommerceconcept.presentation.activity.splashScreen

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.ecommerceconcept.databinding.ActivitySplashScreenBinding
import com.example.ecommerceconcept.presentation.activity.MainActivity
import com.example.ecommerceconcept.utills.BEST_SELLER
import com.example.ecommerceconcept.utills.COUNT_CART
import com.example.ecommerceconcept.utills.HOT_SALES
import com.example.ecommerceconcept.utills.replaceActivity
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private val mViewModel : SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initObservers()
        mViewModel.getHotSales()
    }

    private fun initObservers(){
        mViewModel.bestSeller.observe(this) {
            BEST_SELLER = it.toMutableList()
            mViewModel.getCountCart()
        }
        mViewModel.hotSales.observe(this) {
            HOT_SALES = it.toMutableList()
            mViewModel.getBestSeller()
        }
        mViewModel.countCart.observe(this) {
            COUNT_CART = it
            replaceActivity(this, MainActivity())
        }
    }
}