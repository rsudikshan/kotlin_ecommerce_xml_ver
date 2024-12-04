package com.sr.kt_ecommerce.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sr.kt_ecommerce.R
import java.util.zip.Inflater

class LoginFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container:ViewGroup?, bundle:Bundle?):View{

        var view = inflater.inflate(R.layout.authentication_form,container,false)
        return view;
    }
}