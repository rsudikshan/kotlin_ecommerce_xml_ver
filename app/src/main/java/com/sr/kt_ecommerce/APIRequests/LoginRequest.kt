package com.sr.kt_ecommerce.APIRequests

import android.content.Context
import android.util.Log
import com.sr.kt_ecommerce.Companion.UrlCompanion
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException


class LoginRequest {

    interface LoginRequestListener{
        fun onComplete();
        fun onError();
    }

    fun login(
        loginURL:String,context:Context
        ,username:String
        ,password:String
        ,requestListener:LoginRequestListener){

        val jsonBody = JSONObject().apply {
            put("username",username)
            put("password",password)
        }

        val client = OkHttpClient()
        val mediaType = "application/json; charset=utf-8".toMediaType()

        val requestBody = jsonBody.toString().toRequestBody(mediaType)
        val request = Request.Builder()
            .url(loginURL)
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {

                var jwtToken = response.body?.string()
                Log.d(UrlCompanion.LOGIN_TAG,"$jwtToken")


            }
        })



    }
}