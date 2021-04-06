package com.udacity.shoestore.shoe.detail.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.shoe.detail.viewmodel.ShoeDetailViewModel
import com.udacity.shoestore.shoe.model.Shoe
import com.udacity.shoestore.shoe.viewmodel.ShoeViewModel

class ShoeDetailFragment : Fragment() {
    private val viewModel by activityViewModels<ShoeViewModel>()
    private val fragmentViewModel by viewModels<ShoeDetailViewModel>()
    private lateinit var binding: FragmentShoeDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeDetailBinding.inflate(inflater, container, false).apply {
            fragment = this@ShoeDetailFragment
            viewModel = fragmentViewModel
            lifecycleOwner = this@ShoeDetailFragment
        }
        return binding.root
    }

    fun saveItem(view: View) {
        val shoe = Shoe(
            name = fragmentViewModel.shoeName.value ?: "",
            size = fragmentViewModel.size.value ?: 0.0,
            company = fragmentViewModel.companyName.value ?: "",
            description = fragmentViewModel.description.value ?: ""
        )
        viewModel.addShoe(shoe)
        navigateUp(view)
    }

    fun navigateUp(view: View) {
        view.findNavController().navigateUp()
        hideKeyboard()
    }

    private fun hideKeyboard() {
        val inputService =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputService.hideSoftInputFromWindow(requireView().windowToken, 0)
    }
}