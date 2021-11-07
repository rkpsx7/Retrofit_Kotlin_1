package com.example.retrofit_kotlin_1

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class viewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun setData(responceItem : ResponseItem){
        itemView.apply {
            tvName.text= responceItem.name
            tvEmail.text = responceItem.email
            tvBody.text = responceItem.body
        }
    }
}