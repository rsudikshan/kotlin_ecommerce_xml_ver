package com.sr.kt_ecommerce

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.sr.kt_ecommerce.Fragments.LoginFragment

class MainActivity:AppCompatActivity(){

     override fun onCreate(b: Bundle?){
        super.onCreate(b);
        setContentView(R.layout.main_screen);

         handleFragments()

    }

    fun handleFragments(){
        val accountImageView = findViewById<ImageView>(R.id.account_section);
        accountImageView.setOnClickListener{
            val fragment = LoginFragment();
            val fragmentManager = supportFragmentManager;
            val transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_holder,fragment);
            transaction.commit()
            transaction.addToBackStack(null)
        }

    }



}