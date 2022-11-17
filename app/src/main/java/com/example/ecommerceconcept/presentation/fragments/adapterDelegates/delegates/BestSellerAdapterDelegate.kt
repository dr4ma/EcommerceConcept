package com.example.ecommerceconcept.presentation.fragments.adapterDelegates.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.BestSellerItemRecyclerBinding
import com.example.ecommerceconcept.domain.markers.DisplayableItem
import com.example.ecommerceconcept.domain.models.BestSellerModel
import com.example.ecommerceconcept.presentation.fragments.adapterDelegates.viewHolders.BestSellerViewHolder
import com.example.ecommerceconcept.utills.APP_ACTIVITY_MAIN
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class BestSellerAdapterDelegate : AdapterDelegate<List<DisplayableItem>>() {
    override fun isForViewType(items: List<DisplayableItem>, position: Int): Boolean {
        return items[position] is BestSellerModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = BestSellerItemRecyclerBinding.inflate(
            LayoutInflater.from(APP_ACTIVITY_MAIN),
            parent,
            false
        )
        return BestSellerViewHolder(binding)
    }

    override fun onBindViewHolder(
        items: List<DisplayableItem>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        val item = items[position] as BestSellerModel
        (holder as BestSellerViewHolder).bind(item, holder.itemView, position)
    }
}