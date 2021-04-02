package com.udacity.shoestore.shoe.list.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.shoe.model.Shoe
import com.udacity.shoestore.shoe.viewmodel.ShoeViewModel

class ShoeListFragment : Fragment() {

    private val viewModel by activityViewModels<ShoeViewModel>()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        binding.floatingButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            )
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.shoe.observe(viewLifecycleOwner, {
            it?.forEach { shoe ->
                addShoe(shoe)
            }
        })
    }

    private fun addShoe(shoe: Shoe) {
        val layout = binding.shoeLayout
        layout.addView(createShoeView(shoe))
    }

    private fun createShoeView(shoe: Shoe): View {
        return LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            addView(
                createTextView(
                    text = getString(R.string.shoe_name, shoe.name),
                    typeface = Typeface.BOLD,
                    textSize = 16f
                )
            )
            addView(createTextView(text = getString(R.string.shoe_size, shoe.size), typeface = Typeface.ITALIC))
            addView(createTextView(text = getString(R.string.company_name, shoe.company)))
            addView(createTextView(text = getString(R.string.shoe_description, shoe.description)))
        }
    }

    private fun createTextView(
        text: String,
        typeface: Int = Typeface.NORMAL,
        textSize: Float = 12f
    ): TextView {
        val textView = TextView(requireContext())
        textView.text = text
        textView.setTypeface(textView.typeface, typeface)
        textView.textSize = textSize
        textView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).also {
            val margin = requireContext().resources.getDimension(R.dimen.layout_margin_2x).toInt()
            it.setMargins(margin, 0, margin, margin)
        }
        return textView
    }
}