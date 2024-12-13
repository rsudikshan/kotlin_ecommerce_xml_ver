package com.sr.kt_ecommerce

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.sr.kt_ecommerce.Fragments.LoginFragment
import com.sr.kt_ecommerce.jwtmanager.JwtManagerCompanion

class MainActivity:AppCompatActivity(){

     override fun onCreate(b: Bundle?){
        super.onCreate(b);

        setContentView(R.layout.main_screen)
        JwtManagerCompanion.manager.getKey(this)
        JwtManagerCompanion.manager.clear()

         handleFragments()



     }

    private fun handleFragments(){
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