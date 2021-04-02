package com.udacity.shoestore.shoe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.shoe.model.Shoe

class ShoeViewModel : ViewModel() {

    private val shoeList: MutableList<Shoe> = mutableListOf()
    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoe: LiveData<List<Shoe>>
        get() = _shoes

    init {
        _shoes.value = shoeList
    }

    fun addShoe(shoe: Shoe) {
        shoeList.add(shoe)
        _shoes.value = shoeList
    }

    fun resetShoeList() {
        shoeList.clear()
    }
}