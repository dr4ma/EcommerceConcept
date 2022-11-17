package com.example.ecommerceconcept.presentation.fragments.adapterDelegates.viewHolders

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.BestSellerItemRecyclerBinding
import com.example.ecommerceconcept.domain.markers.DisplayableItem
import com.example.ecommerceconcept.domain.models.BestSellerModel
import com.example.ecommerceconcept.presentation.fragments.explorerFragment.ExplorerFragment
import com.example.ecommerceconcept.utills.downloadIcon

class BestSellerViewHolder(private val binding: BestSellerItemRecyclerBinding) :  RecyclerView.ViewHolder(binding.root), AdapterHolder {
    @SuppressLint("SetTextI18n")
    override fun bind(model: DisplayableItem, itemView: View, position: Int) {
        binding.apply {
            imageSeller.downloadIcon((model as BestSellerModel).picture)
            priceDiscount.text = "$" + model.discount_price.toString()
            priceWithoutDiscount.text = "$" +  model.price_without_discount.toString()
            priceWithoutDiscount.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            nameSeller.text = model.title
            favoritesSeller.isSelected = model.is_favorites

            favoritesSeller.setOnClickListener{
                favoritesSeller.isSelected = !favoritesSeller.isSelected
            }
        }
        itemView.setOnClickListener {
            ExplorerFragment.openDetails()
        }
    }
}