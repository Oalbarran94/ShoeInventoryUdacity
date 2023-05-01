package com.example.shoestore.screens.shoes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.databinding.ShoeItemBinding
import com.example.shoestore.model.ShoeListViewModel

import android.view.*
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle


class ShoeListFragment : Fragment(), MenuProvider {

    private lateinit var binding : FragmentShoeListBinding

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("onCreateView", "onCreateView")

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )
        //setHasOptionsMenu(true)
        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
        binding.lifecycleOwner = this


        binding.addItem.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_addShoeFragment)
        }

        Log.i("stuff from view model", viewModel.shoeList.toString())
        Log.i("added", viewModel.shoeList.value?.size.toString())

        viewModel.shoeList.observe(this.viewLifecycleOwner, Observer { shoeElements ->
            shoeElements.forEach{ shoe ->
                Log.i("Inside foreach", "Inside foreach")
                val shoeItem = ShoeItemBinding.inflate(layoutInflater)
                shoeItem.shoe = shoe
                binding.linear1.addView(shoeItem.root)
            }
        })

        return binding.root
    }


    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_logout, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId){
            R.id.logout -> findNavController().navigate(R.id.action_shoeListFragment_to_titleFragment)
        }
        return true
    }
}