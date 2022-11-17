package com.example.ecommerceconcept.presentation.fragments.cartFragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.FragmentCartBinding
import com.example.ecommerceconcept.presentation.fragments.adapterDelegates.MainListAdapter
import com.example.ecommerceconcept.utills.APP_ACTIVITY_MAIN
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CartFragment : Fragment() {

    private val mViewModel: CartViewModel by viewModels()
    private var binding: FragmentCartBinding? = null
    private val mBinding get() = binding!!
    private lateinit var mRecycler : RecyclerView
    private lateinit var mBackPressed : MaterialButton

    @Inject
    lateinit var mAdapter : MainListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(layoutInflater, container, false)
        mBinding.apply {
            mRecycler = recyclerCart
            mBackPressed = backPressed
        }
        return mBinding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()

        initFields()
        mViewModel.basket.observe(viewLifecycleOwner){
            mAdapter.setItems(it.basket){
                mRecycler.adapter = mAdapter
            }
            mBinding.apply {
                totalPrice.text = "$${it.total} us"
                delivery.text = it.delivery
            }
        }
        mViewModel.getCart()
    }

    private fun initFields(){
        mBackPressed.setOnClickListener {
            APP_ACTIVITY_MAIN.onBackPressed()
        }
    }
}