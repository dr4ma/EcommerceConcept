package com.example.ecommerceconcept.presentation

import android.view.LayoutInflater
import android.view.View
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.utills.APP_ACTIVITY_MAIN
import com.example.ecommerceconcept.utills.BottomSheetSettings
import com.google.android.material.bottomsheet.BottomSheetDialog

object BottomSheetApp {

    fun create(type: BottomSheetSettings) {
        when (type) {
            BottomSheetSettings.FILTER_BOTTOM_SHEET -> {
                val bottomSheetDialog =
                    BottomSheetDialog(APP_ACTIVITY_MAIN, R.style.BottomSheetDialogTheme)
                val bottomSheetView = LayoutInflater.from(APP_ACTIVITY_MAIN)
                    .inflate(R.layout.bottom_sheet_filters, null)
                bottomSheetView.findViewById<View>(R.id.close_filters).setOnClickListener {
                    bottomSheetDialog.dismiss()
                }
                bottomSheetView.findViewById<View>(R.id.done_filters).setOnClickListener {
                    bottomSheetDialog.dismiss()
                }
                bottomSheetDialog.window?.setDimAmount(0F)
                bottomSheetDialog.setContentView(bottomSheetView)
                bottomSheetDialog.show()
            }
        }
    }
}