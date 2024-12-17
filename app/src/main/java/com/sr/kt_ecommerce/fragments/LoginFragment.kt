package com.sr.kt_ecommerce.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sr.kt_ecommerce.api.LoginRequest
import com.sr.kt_ecommerce.companion.UrlCompanion
import com.sr.kt_ecommerce.R


class LoginFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container:ViewGroup?, bundle:Bundle?):View{

        val view = inflater.inflate(R.layout.authentication_form,container,false)
        val login = view.findViewById<Button>(R.id.login_button);
        val loginRequest = LoginRequest();
        val usernameTv = view.findViewById<EditText>(R.id.login_username_input)
        val passwordTv = view.findViewById<EditText>(R.id.login_password_input)
        val progressBar = view.findViewById<ProgressBar>(R.id.auth_form_progress_bar);
        val registerRedirect = view.findViewById<TextView>(R.id.register_link);


        registerRedirect.setOnClickListener{
            val registerFragment = RegisterFragment()
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_holder,registerFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }





        login.setOnClickListener {
            val username =  usernameTv.text.toString()
            val password = passwordTv.text.toString()

            if(username.isNotEmpty() && password.isNotEmpty()){
                progressBar.visibility = View.VISIBLE
                loginRequest.login(UrlCompanion.LOGIN_URL,
                    requireContext(),
                    username,
                    password,
                    object : LoginRequest.LoginRequestListener {
                        override fun onError() {
                            progressBar.visibility = View.INVISIBLE

                        }

                        override fun onComplete() {
                            requireActivity().runOnUiThread{
                                progressBar.visibility = View.INVISIBLE
                                Toast.makeText(requireContext(),"Logged IN",Toast.LENGTH_SHORT).show()
                            }

                        }
                    }
                );
            }
            else{
                Toast.makeText(context,"Please fill all fields.",Toast.LENGTH_SHORT).show();
            }





        }

        return view;
    }
}