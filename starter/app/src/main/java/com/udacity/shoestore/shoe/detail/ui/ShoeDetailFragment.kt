package com.udacity.shoestore.shoe.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.shoe.model.Shoe
import com.udacity.shoestore.shoe.viewmodel.ShoeViewModel

class ShoeDetailFragment : Fragment() {
    private val viewModel by activityViewModels<ShoeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentShoeDetailBinding.inflate(inflater, container, false)
        binding.buttonCancel.setOnClickListener {
            // is it the right way to use navigate up or should I use directions?
            it.findNavController().navigateUp()
//            Navigation.createNavigateOnClickListener(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.buttonSave.setOnClickListener {
            val shoe = Shoe(
                name = binding.editTextShoeName.text.toString(),
                size = binding.editTextShoeSize.text.toString().toDouble(),
                company = binding.editTextCompanyName.text.toString(),
                description = binding.editTextDescription.text.toString()
            )
            viewModel.addShoe(shoe)
            it.findNavController().navigateUp()
        }
        return binding.root
    }
}