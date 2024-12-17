package com.sr.kt_ecommerce.viewholder

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sr.kt_ecommerce.R

class ExploreRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    lateinit var productImage:ImageView
    lateinit var productName:TextView
    lateinit var productPrice:TextView
    lateinit var order:Button

    fun findAndAssign(){
        productImage = itemView.findViewById(R.id.explore_product_image)
        productName = itemView.findViewById(R.id.explore_product_name)
        order = itemView.findViewById(R.id.explore_order_button)


    }

}