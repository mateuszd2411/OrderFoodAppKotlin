package com.ganarstudio.orderfoodappkotlin.Callback

import com.ganarstudio.orderfoodappkotlin.Model.CategoryModel

interface ICategoryCallbackListener {
    fun onCategoryLoadSuccess(categoriesList: List<CategoryModel>)
    fun onCategoryLoadFailed(message:String)
}