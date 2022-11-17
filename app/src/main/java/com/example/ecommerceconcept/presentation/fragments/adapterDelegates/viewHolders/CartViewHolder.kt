package com.example.ecommerceconcept.presentation.fragments.adapterDelegates.viewHolders

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.BestSellerItemRecyclerBinding
import com.example.ecommerceconcept.databinding.ItemCartRecyclerBinding
import com.example.ecommerceconcept.domain.markers.DisplayableItem
import com.example.ecommerceconcept.domain.models.BestSellerModel
import com.example.ecommerceconcept.domain.models.SingleElementCartModel
import com.example.ecommerceconcept.utills.downloadIcon

class CartViewHolder(private val binding: ItemCartRecyclerBinding) :  RecyclerView.ViewHolder(binding.root), AdapterHolder {
    @SuppressLint("SetTextI18n")
    override fun bind(model: DisplayableItem, itemView: View, position: Int) {
        binding.apply {
            iconCart.downloadIcon((model as SingleElementCartModel).images)
            titleCart.text = model.title
            priceCart.text = "$${model.price.toString()}"

        }
    }
}