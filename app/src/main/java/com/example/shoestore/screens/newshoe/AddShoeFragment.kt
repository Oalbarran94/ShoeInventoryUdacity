package com.example.shoestore.screens.newshoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentAddShoeBinding
import com.example.shoestore.model.ShoeListViewModel


class AddShoeFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : FragmentAddShoeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add_shoe, container, false
        )

        binding.lifecycleOwner = this
        binding.shoemodel = viewModel

        binding.saveButton.setOnClickListener {
            viewModel.addShoeItem()
            findNavController().navigate(R.id.action_addShoeFragment_to_shoeListFragment)
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_addShoeFragment_to_shoeListFragment)
        }

        return binding.root
    }
}