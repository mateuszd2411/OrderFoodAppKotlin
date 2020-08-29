package com.ganarstudio.orderfoodappkotlin.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Categories Fragment"
    }
    val text: LiveData<String> = _text
}