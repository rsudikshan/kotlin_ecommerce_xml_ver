package com.sr.kt_ecommerce.APIRequests

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class LoginRequest {
    fun login(loginURL:String,context:Context, username:String, password:String){

        val reqObject = Volley.newRequestQueue(context);

        val stringRequest  = object:StringRequest(Request.Method.POST,loginURL,
            {

                response->


                //Log.d( "LOGIN", response)

            },
            {

                error->
                Log.d("LOGIN",username)
                Log.d("LOGIN", password)
                Log.d("LOGIN", error.toString())

            }
            ){

            override fun getParams(): MutableMap<String, String>? {
                var map = mutableMapOf<String, String>()
                map["username"] = username
                map["password"] = password


                return map
            }
        }




        reqObject.add(stringRequest)

    }
}