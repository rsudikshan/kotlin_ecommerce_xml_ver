package com.sr.kt_ecommerce.api

import android.content.Context
import android.util.Log
import com.sr.kt_ecommerce.companion.UrlCompanion
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class RegisterRequest {
    interface RegisterRequestCompletionListener{
        fun onComplete();
        fun onError();
        fun onServerError();
    }

    fun register(
        context:Context,
        url:String,
        jsonBody:JSONObject,
        completionListener: RegisterRequestCompletionListener
    ){

        Log.d(UrlCompanion.REGISTER_TAG,"Hitting here")
        val mediaType = "application/json; charset=utf-8".toMediaType()
        val client = OkHttpClient();
        val request =  Request.Builder()
            .url(url)
            .post(jsonBody.toString().toRequestBody(mediaType))
            .build()
        client.newCall(request).enqueue(
            object: Callback{
                override fun onFailure(call: Call, e: IOException) {
                    Log.d(UrlCompanion.REGISTER_TAG,e.toString())
                    Log.d(UrlCompanion.REGISTER_TAG, UrlCompanion.REGISTER_URL)
                }

                override fun onResponse(call: Call, response: Response) {
                    Log.d(UrlCompanion.REGISTER_TAG,response.body.toString())
                    val responseBody = response.body?.string()

                    val responseObject = responseBody?.let { JSONObject(it) }
                    if(responseObject?.getString("status").equals("successful")){
                        completionListener.onComplete()
                    }
                    else if (responseObject?.getString("status").equals("email already exists")){
                        completionListener.onServerError()
                    }
                }
            }
        )
    }
}