package com.example.ecommerceconcept.utills

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.domain.models.SelectCategoryModel
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

fun AppCompatActivity.replaceActivity(context: Context, activity: AppCompatActivity) {
    val intent = Intent(context, activity::class.java)
    startActivity(intent)
    this.finish()
}

fun createListCategory(): MutableList<SelectCategoryModel> {
    val list = mutableListOf<SelectCategoryModel>()
    for (i in 0..5) {
        when (i) {
            0 -> {
                list.add(
                    SelectCategoryModel(
                        icon = R.drawable.ic_phone,
                        label = APP_ACTIVITY_MAIN.getString(R.string.phones)
                    )
                )
            }
            1 -> {
                list.add(
                    SelectCategoryModel(
                        icon = R.drawable.ic_computer,
                        label = APP_ACTIVITY_MAIN.getString(R.string.computer)
                    )
                )
            }
            2 -> {
                list.add(
                    SelectCategoryModel(
                        icon = R.drawable.ic_health,
                        label = APP_ACTIVITY_MAIN.getString(R.string.health)
                    )
                )
            }
            3 -> {
                list.add(
                    SelectCategoryModel(
                        icon = R.drawable.ic_books,
                        label = APP_ACTIVITY_MAIN.getString(R.string.books)
                    )
                )
            }
            4 -> {
                list.add(
                    SelectCategoryModel(
                        icon = R.drawable.ictools,
                        label = APP_ACTIVITY_MAIN.getString(R.string.tools)
                    )
                )
            }
        }
    }
    return list
}

fun ImageView.downloadIcon(path: String) {
    Picasso.get().load(path)
        .placeholder(R.drawable.ic_image)
        .error(R.drawable.ic_image)
        .into(this)
}