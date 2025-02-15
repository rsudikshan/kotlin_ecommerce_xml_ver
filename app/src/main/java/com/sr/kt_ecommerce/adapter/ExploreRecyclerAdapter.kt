package com.sr.kt_ecommerce.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sr.kt_ecommerce.R
import com.sr.kt_ecommerce.companion.UrlCompanion
import com.sr.kt_ecommerce.viewholder.ExploreRecyclerViewHolder

class ExploreRecyclerAdapter(
    private val productName: MutableList<String>,
    private val productPrice: MutableList<String>,
    private val productImageUrl: MutableList<String>,
    private val context:Context

): RecyclerView.Adapter<ExploreRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreRecyclerViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.explore_fragment_custom_item
        ,parent
        ,false)
        val exploreRecyclerViewHolder = ExploreRecyclerViewHolder(itemView)
        exploreRecyclerViewHolder.findAndAssign()
        return exploreRecyclerViewHolder
    }

    override fun getItemCount(): Int {
        return productName.size
    }

    override fun onBindViewHolder(holder: ExploreRecyclerViewHolder, position: Int) {
        holder.productName.text = productName[position]
        Log.d(UrlCompanion.PRODUCT_TAG,productImageUrl[position])
        Picasso.get().load(UrlCompanion.MAIN_URL+productImageUrl[position]).into(holder.productImage)

    }
}