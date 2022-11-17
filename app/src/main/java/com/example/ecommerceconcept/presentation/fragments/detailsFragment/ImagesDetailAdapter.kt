package com.example.ecommerceconcept.presentation.fragments.detailsFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.ItemImagesDetailsBinding
import com.example.ecommerceconcept.utills.APP_ACTIVITY_MAIN
import com.example.ecommerceconcept.utills.downloadIcon

class ImagesDetailAdapter : RecyclerView.Adapter<ImagesDetailAdapter.ImagesDetailHolder>() {

    private var listImages = mutableListOf<String>()

    inner class ImagesDetailHolder(private val binding: ItemImagesDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(item: String) {
            with(binding) {
                imageDetails.downloadIcon(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesDetailHolder {
        val binding = ItemImagesDetailsBinding.inflate(
            LayoutInflater.from(APP_ACTIVITY_MAIN),
            parent,
            false
        )
        return ImagesDetailHolder(binding)
    }

    override fun onBindViewHolder(holder: ImagesDetailHolder, position: Int) {
        holder.bind(listImages[position])
    }

    override fun getItemCount(): Int {
        return listImages.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList: MutableList<String>) {
        listImages = newList
        notifyDataSetChanged()
    }
}