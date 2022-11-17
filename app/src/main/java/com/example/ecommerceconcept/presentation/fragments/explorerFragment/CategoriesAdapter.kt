package com.example.ecommerceconcept.presentation.fragments.explorerFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.CategoryItemRecyclerBinding
import com.example.ecommerceconcept.domain.models.SelectCategoryModel
import com.example.ecommerceconcept.utills.APP_ACTIVITY_MAIN

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder>() {

    private var listCategories = mutableListOf<SelectCategoryModel>()
    private var selectedItemPosition: Int = 0
    private var oldItemPosition: Int = 0

    inner class CategoriesHolder(private val binding: CategoryItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(category: SelectCategoryModel) {
            with(binding) {
                iconCategory.setImageDrawable(
                    APP_ACTIVITY_MAIN.resources.getDrawable(
                        category.icon,
                        APP_ACTIVITY_MAIN.theme
                    )
                )
                categoryLabel.text = category.label
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesHolder {
        val binding = CategoryItemRecyclerBinding.inflate(
            LayoutInflater.from(APP_ACTIVITY_MAIN),
            parent,
            false
        )
        return CategoriesHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesHolder, position: Int) {
        holder.bind(listCategories[position])
        holder.itemView.isSelected = selectedItemPosition == holder.absoluteAdapterPosition
    }

    override fun onViewAttachedToWindow(holder: CategoriesHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            oldItemPosition = selectedItemPosition
            selectedItemPosition = holder.absoluteAdapterPosition
            notifyItemChanged(oldItemPosition)
            notifyItemChanged(selectedItemPosition)
        }
    }

    override fun getItemCount(): Int {
        return listCategories.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList: MutableList<SelectCategoryModel>) {
        listCategories = newList
        notifyDataSetChanged()
    }
}