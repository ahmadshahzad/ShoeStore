package com.udacity.shoestore.instructions.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInstructionsBinding.inflate(layoutInflater, container, false)
        binding.navigationButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_instructionsFragment_to_shoeListFragment))
        return binding.root
    }
}