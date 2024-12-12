package com.sr.kt_ecommerce.APIRequests

import android.content.Context
import android.util.Log
import androidx.coordinatorlayout.R
import com.sr.kt_ecommerce.Companion.UrlCompanion
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okhttp3.internal.wait
import org.json.JSONObject
import java.io.IOException

class RegisterRequest {


    interface RegisterRequestListener{
        fun onComplete()
        fun onError()
    }

    fun register(context:Context,jsonBody: JSONObject){
        val client = OkHttpClient()
        val mediaType = "application/json; charset=utf-8".toMediaType()

        // Create the Request Body
        val requestBody = jsonBody.toString().toRequestBody(mediaType)

        val request = Request.Builder()
            .url(UrlCompanion.REGISTER_URL)
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object:Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.d(UrlCompanion.REGISTER_TAG,e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d(UrlCompanion.REGISTER_TAG,response.body.toString())
            }
        }
        )


    }
}