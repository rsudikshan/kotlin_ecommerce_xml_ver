package com.sr.kt_ecommerce.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sr.kt_ecommerce.R
import com.sr.kt_ecommerce.adapter.ExploreRecyclerAdapter
import com.sr.kt_ecommerce.api.ProductRequest
import com.sr.kt_ecommerce.companion.ProductCompanion

class ExploreFragment : Fragment(){
    private lateinit var rootVew:View;
    lateinit var recycler:RecyclerView

    override fun onCreateView( inflater:LayoutInflater, container:ViewGroup? , b:Bundle?): View {

        rootVew = inflater.inflate(R.layout.explore_fragment,container,false)
        recycler = rootVew.findViewById(R.id.explore_recycler)

        fragmentHandler()

        return rootVew

    }

    private fun fragmentHandler() {
        recycler.layoutManager = LinearLayoutManager(requireContext())
        ProductRequest().getProducts(object : ProductRequest.ProductRequestListener {
            override fun onComplete() {
                // Check if adapter is already set
                requireActivity().runOnUiThread {
                    if (recycler.adapter == null) {
                        val adapter = ExploreRecyclerAdapter(
                            ProductCompanion.productNameCompanion,
                            ProductCompanion.productPriceCompanion,
                            ProductCompanion.imageUrlCompanion,
                            requireContext()
                        )
                        recycler.adapter = adapter


                    } else {
                        //the adapter is already set, just notify data change
                        (recycler.adapter as ExploreRecyclerAdapter).notifyDataSetChanged()
                    }
                }
            }

            override fun onError() {
                // Handle error case here
            }
        })
    }

}