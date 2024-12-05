package com.sr.kt_ecommerce.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.sr.kt_ecommerce.APIRequests.LoginRequest
import com.sr.kt_ecommerce.R


class LoginFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container:ViewGroup?, bundle:Bundle?):View{

        val view = inflater.inflate(R.layout.authentication_form,container,false)
        val login = view.findViewById<Button>(R.id.login_button);
        val loginRequest = LoginRequest();
        val usernameTv = view.findViewById<EditText>(R.id.login_username_input)
        val passwordTv = view.findViewById<EditText>(R.id.login_password_input)

        login.setOnClickListener {
            val username =  usernameTv.text.toString()
            val password = passwordTv.text.toString()

            loginRequest.login("https://feb4-2400-1a00-b060-2869-d49d-92f1-e0d1-a92c.ngrok-free.app/login",
                requireContext(),
                username,
                password
                );



        }

        return view;
    }
}