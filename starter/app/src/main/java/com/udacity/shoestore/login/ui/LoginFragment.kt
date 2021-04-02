package com.udacity.shoestore.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        binding.buttonLogin.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
            )
        )
        return binding.root
    }
}