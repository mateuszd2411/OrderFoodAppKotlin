package com.ganarstudio.orderfoodappkotlin.ui.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ganarstudio.orderfoodappkotlin.Callback.ICategoryCallbackListener
import com.ganarstudio.orderfoodappkotlin.Model.CategoryModel

class MenuViewModel : ViewModel(), ICategoryCallbackListener {

    override fun onCategoryLoadSuccess(categoriesList: List<CategoryModel>) {
        categoriesListMutable?.value = categoriesList
    }

    override fun onCategoryLoadFailed(message: String) {
        messageError.value = message
    }

    private var categoriesListMutable: MutableLiveData<List<CategoryModel>>? = null
    private var messageError: MutableLiveData<String> = MutableLiveData()
    private val categoryCallBackListener: ICategoryCallbackListener

    init {
        categoryCallBackListener = this
    }

    fun getCategoryList(): MutableLiveData<List<CategoryModel>> {
        if (categoriesListMutable == null) {

        }
        return  categoriesListMutable!!
    }

}