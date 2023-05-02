package com.example.shoestore.model;

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ShoeListViewModel : ViewModel() {

    var shoeName = ""
    var shoeSize = "0"
    var shoeCompany = ""
    var shoeDescription = ""

    var initialShoeList = mutableListOf(
        Shoe(1, "crazy shoe", "Just a crazy shoe", "Nike", "10"),
        Shoe(2, "cool shoe", "Just a cool shoe", "Jordan", "15"))

    private val _shoeList = MutableLiveData<List<Shoe>>(initialShoeList)

    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    fun addShoeItem(){
        Log.i("ShoeListViewModel", "Adding Shoe")
        val shoe = Shoe(Random.nextInt(0, 100), shoeName, shoeDescription, shoeCompany, shoeSize)
        initialShoeList.add(shoe)

        _shoeList.value = initialShoeList
        _shoeList.postValue(initialShoeList)
    }
}
