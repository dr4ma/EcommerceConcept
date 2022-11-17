package com.example.ecommerceconcept.presentation.fragments.explorerFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.HotSalesItemRecyclerBinding
import com.example.ecommerceconcept.domain.models.HotSalesModel
import com.example.ecommerceconcept.utills.APP_ACTIVITY_MAIN
import com.example.ecommerceconcept.utills.downloadIcon

class HotSalesAdapter : RecyclerView.Adapter<HotSalesAdapter.HotSalesHolder>() {

    private var listSales = mutableListOf<HotSalesModel>()

    inner class HotSalesHolder(private val binding: HotSalesItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(item: HotSalesModel) {
            with(binding) {
                if(item.is_new){
                    newLabel.visibility = View.VISIBLE
                }
                title.text = item.title
                subTitle.text = item.subtitle
                picture.downloadIcon(item.picture)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesHolder {
        val binding = HotSalesItemRecyclerBinding.inflate(
            LayoutInflater.from(APP_ACTIVITY_MAIN),
            parent,
            false
        )
        return HotSalesHolder(binding)
    }

    override fun onBindViewHolder(holder: HotSalesHolder, position: Int) {
        holder.bind(listSales[position])
    }

    override fun getItemCount(): Int {
        return listSales.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList: MutableList<HotSalesModel>) {
        listSales = newList
        notifyDataSetChanged()
    }
}