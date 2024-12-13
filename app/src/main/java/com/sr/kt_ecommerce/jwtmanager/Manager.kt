package com.sr.kt_ecommerce.jwtmanager

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class Manager {

    private lateinit var editor:SharedPreferences.Editor;


    fun getKey(context:Context){
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        val sharedPreferences = EncryptedSharedPreferences.create(context,
            "secure_prefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM)

        editor = sharedPreferences.edit()

    }

    fun setJwt(jwtToken:String?){

        editor.putString("bearer ", jwtToken)
        editor.apply()
    }

    fun clear(){
        editor.remove("bearer ")
        editor.clear().apply()
    }
}