package com.example.shoestore.screens.login;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment(){

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {

            val binding: LoginFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.login_fragment, container, false
            )

            binding.buttonLogin.setOnClickListener {
                findNavController().navigate(R.id.action_titleFragment_to_welcomeFragment)
            }

            binding.buttonRegister.setOnClickListener {
                findNavController().navigate(R.id.action_titleFragment_to_welcomeFragment)
            }

            return binding.root
        }

}
