package com.ganarstudio.orderfoodappkotlin.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ganarstudio.orderfoodappkotlin.Callback.IPopularLoadCallback
import com.ganarstudio.orderfoodappkotlin.Model.PopularCategoryModel

class HomeViewModel : ViewModel(), IPopularLoadCallback {
    override fun onPopularLoadSuccess(popularModelList: List<PopularCategoryModel>) {
        popularListMutableLiveData.value = popularModelList
    }

    override fun onPopularLoadFailed(message: String) {
        messageError.value = message
    }

    private lateinit var popularListMutableLiveData: MutableLiveData<List<PopularCategoryModel>>
    private lateinit var messageError: MutableLiveData<String>
    private lateinit var popularLoadCallbackListener: IPopularLoadCallback

    val popularList: LiveData<List<PopularCategoryModel>>
        get() {
            if (popularListMutableLiveData == null) {
                popularListMutableLiveData = MutableLiveData()
                messageError = MutableLiveData()
                loadPopularList()
            }
            return popularListMutableLiveData
        }

    init {
        popularLoadCallbackListener = this
    }

    private fun loadPopularList() {

    }

}