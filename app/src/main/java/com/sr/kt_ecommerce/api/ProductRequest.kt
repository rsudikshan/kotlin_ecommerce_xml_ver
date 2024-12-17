package com.sr.kt_ecommerce.api

import com.sr.kt_ecommerce.companion.ProductCompanion
import com.sr.kt_ecommerce.companion.UrlCompanion
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class ProductRequest {
    interface ProductRequestListener{

        fun onComplete()
        fun onError()

    }


    fun getProducts( requestListener: ProductRequestListener){

        val client = OkHttpClient()
        val request = Request.Builder()
                    .url(UrlCompanion.PRODUCT_URL)
                    .get()
                    .build()

        client.newCall(request).enqueue(
            object:Callback {
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    val responseBody = response.body?.string()
                    println("Response Body: $responseBody")

                    if (responseBody != null) {
                        try {
                            val responseJsonArray = JSONArray(responseBody)
                            val length = responseJsonArray.length()

                            for (i in 0 until length) {
                                val responseResult = responseJsonArray.getJSONObject(i)
                                ProductCompanion.productNameCompanion.add(responseResult.getString("productName"))
                                ProductCompanion.imageUrlCompanion.add(responseResult.getString("imageName"))

                            }
                            requestListener.onComplete()
                        } catch (e: Exception) {
                            e.printStackTrace()
                            requestListener.onError()
                        }
                    } else {
                        requestListener.onError()
                    }
                }

            }
                    )
    }
}