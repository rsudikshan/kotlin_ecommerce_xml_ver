package com.sr.kt_ecommerce.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sr.kt_ecommerce.R
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
        //Picasso.get().load(productImageUrl[position]).into(holder.productImage)

    }
}