package com.example.ecommerceconcept.presentation.fragments.adapterDelegates

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.domain.markers.DisplayableItem
import com.example.ecommerceconcept.presentation.fragments.adapterDelegates.delegates.*
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import javax.inject.Inject

class MainListAdapter @Inject constructor(
    bestSellerAdapterDelegate: BestSellerAdapterDelegate,
    cartAdapterDelegate: CartAdapterDelegate
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val delegatesManager = AdapterDelegatesManager<List<DisplayableItem>>()
    private var items = listOf<DisplayableItem>()

    init {
        delegatesManager.addDelegate(bestSellerAdapterDelegate)
        delegatesManager.addDelegate(cartAdapterDelegate)
    }

    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(items, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegatesManager.onBindViewHolder(items, position, holder)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    fun setItems(newItems: List<DisplayableItem>, onSuccess: () -> Unit) {
        items = newItems
        onSuccess()
    }
}