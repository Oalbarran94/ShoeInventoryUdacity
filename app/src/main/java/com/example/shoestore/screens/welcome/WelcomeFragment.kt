package com.example.shoestore.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeBinding = FragmentWelcomeBinding.inflate(inflater, container, false)

        binding.welcomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_instructionFragment)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}