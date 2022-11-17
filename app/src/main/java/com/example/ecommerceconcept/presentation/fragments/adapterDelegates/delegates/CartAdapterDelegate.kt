package com.example.ecommerceconcept.presentation.fragments.adapterDelegates.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.BestSellerItemRecyclerBinding
import com.example.ecommerceconcept.databinding.ItemCartRecyclerBinding
import com.example.ecommerceconcept.domain.markers.DisplayableItem
import com.example.ecommerceconcept.domain.models.BestSellerModel
import com.example.ecommerceconcept.domain.models.SingleElementCartModel
import com.example.ecommerceconcept.presentation.fragments.adapterDelegates.viewHolders.BestSellerViewHolder
import com.example.ecommerceconcept.presentation.fragments.adapterDelegates.viewHolders.CartViewHolder
import com.example.ecommerceconcept.utills.APP_ACTIVITY_MAIN
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class CartAdapterDelegate : AdapterDelegate<List<DisplayableItem>>() {
    override fun isForViewType(items: List<DisplayableItem>, position: Int): Boolean {
        return items[position] is SingleElementCartModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = ItemCartRecyclerBinding.inflate(
            LayoutInflater.from(APP_ACTIVITY_MAIN),
            parent,
            false
        )
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(
        items: List<DisplayableItem>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        val item = items[position] as SingleElementCartModel
        (holder as CartViewHolder).bind(item, holder.itemView, position)
    }
}