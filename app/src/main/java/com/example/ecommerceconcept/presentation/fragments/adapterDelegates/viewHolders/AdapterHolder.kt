package com.example.ecommerceconcept.presentation.fragments.adapterDelegates.viewHolders

import android.view.View
import com.example.ecommerceconcept.domain.markers.DisplayableItem
import java.text.FieldPosition

interface AdapterHolder {
    fun bind(model : DisplayableItem, itemView : View, position: Int)
}