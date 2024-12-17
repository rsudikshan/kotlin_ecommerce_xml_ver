package com.sr.kt_ecommerce

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.sr.kt_ecommerce.fragments.ExploreFragment
import com.sr.kt_ecommerce.fragments.LoginFragment
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
        val exploreImageView = findViewById<ImageView>(R.id.explore);

        accountImageView.setOnClickListener{
            val fragment = LoginFragment();
            val fragmentManager = supportFragmentManager;
            val transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_holder,fragment);
            transaction.addToBackStack(null)
            transaction.commit()

        }

        exploreImageView.setOnClickListener{
            val fragment = ExploreFragment();
            val fragmentManager = supportFragmentManager;
            val transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_holder,fragment);
            transaction.addToBackStack(null)
            transaction.commit()

        }

    }



}