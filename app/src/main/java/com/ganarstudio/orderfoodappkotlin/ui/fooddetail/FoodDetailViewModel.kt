package com.ganarstudio.orderfoodappkotlin.ui.fooddetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ganarstudio.orderfoodappkotlin.Common.Common
import com.ganarstudio.orderfoodappkotlin.Model.FoodModel

class FoodDetailViewModel : ViewModel() {

    private var mutableLiveData: MutableLiveData<FoodModel> ?= null

    fun getMutableLiveDataFood(): MutableLiveData<FoodModel> {
        if (mutableLiveData == null)
            mutableLiveData = MutableLiveData()
        mutableLiveData!!.value = Common.foodSelected
        return mutableLiveData!!
    }
}