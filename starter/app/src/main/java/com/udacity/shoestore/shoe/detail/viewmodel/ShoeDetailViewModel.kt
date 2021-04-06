package com.udacity.shoestore.shoe.detail.viewmodel

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel : ViewModel(), Observable {
    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    @Bindable
    var shoeName = MutableLiveData<String>()

    @Bindable
    var companyName = MutableLiveData<String>()

    @Bindable
    var size = MutableLiveData<Double>()

    @Bindable
    var description = MutableLiveData<String>()

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }
}

@BindingAdapter("app:bindingText")
fun EditText.setText(value: Double) {
    setText(value.toString())
}

@BindingAdapter(value = ["app:bindingTextAttrChanged"])
fun EditText.setListener(listener: InverseBindingListener?) {
    onFocusChangeListener = View.OnFocusChangeListener { focusedView, hasFocus ->
        val textView = focusedView as TextView
        if (hasFocus && textView.text.toString() == "0.0") {
            // Delete contents of the EditText if the focus entered first time.
            textView.text = ""
        } else {
            // If the focus left, update the listener
            listener?.onChange()
        }
    }
}

@InverseBindingAdapter(attribute = "app:bindingText")
fun EditText.getText(): Double {
    return text.toString().toDouble()
}