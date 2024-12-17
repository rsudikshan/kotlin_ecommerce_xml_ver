package com.sr.kt_ecommerce.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.sr.kt_ecommerce.api.RegisterRequest
import com.sr.kt_ecommerce.R
import org.json.JSONObject

class RegisterFragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater,viewGroup: ViewGroup?,bundle: Bundle?):View{
        val view = inflater.inflate(R.layout.registration_form,viewGroup,false)
        val progressBar = view.findViewById<ProgressBar>(R.id.register_form_progress_bar)
        val email = view.findViewById<EditText>(R.id.register_email_input)
        val username = view.findViewById<EditText>(R.id.register_username_input)
        val password = view.findViewById<EditText>(R.id.register_password_input)
        val submit = view.findViewById<Button>(R.id.register_button)
        var request = RegisterRequest();

        submit.setOnClickListener{

            val emailInput = email.text.toString()
            val usernameInput = username.text.toString()
            val passwordInput = password.text.toString()

            val jsonBody = JSONObject().apply {
                put("email", emailInput)
                put("username", usernameInput)
                put("password", passwordInput)
            }




            request.register(requireContext(),jsonBody)

        }


        return view
    }

}